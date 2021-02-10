package com.yulong.spark.master

import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import com.yulong.spark.common._

import scala.collection.mutable
import scala.concurrent.duration._

/**
  * spark master endpoint
  */
class Master extends Actor {
  val workerInfo = mutable.Map[String, WorkerInfo]()


  override def receive: Receive = {
    case "start" => {
      println("spark master starting...")
      self ! StartTimeOutWorker
    }
    case RegisterWorkerInfo(id, cpu, ram) => {
      if (!workerInfo.contains(id)) {
        val map = new WorkerInfo(id, cpu, ram)
        workerInfo += ((id, map))
        //返回注册成功
        sender() ! RegisterWorkerInfo
      }
    }
    case HeartBeat(id) => {
      val workerLastHeartBeat = workerInfo(id)
      workerLastHeartBeat.lastHeartBeat = System.currentTimeMillis()
      println(s"master 更新心跳时间，（$id） 心跳时间...")
    }
    case StartTimeOutWorker => {
      println("开始定时监测worker心跳任务")
      import context.dispatcher
      context.system.scheduler.schedule(0 millis, 8000 millis, self, RemoveTimeOutWorker)
    }
    case RemoveTimeOutWorker => {
      val workerInfos = workerInfo.values
      val now_time = System.currentTimeMillis()
      workerInfos.filter(workerInfo => (now_time - workerInfo.lastHeartBeat) > 6000)
        .foreach(removeWorker => workerInfo.remove(removeWorker.id))
      println(s"当前有${workerInfo.size} 存活")
    }
  }

}

object Master {
  def main(args: Array[String]): Unit = {

    val config = ConfigFactory.parseString(
      s"""
         |akka.actor.provider="akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname="127.0.0.1"
         |akka.remote.netty.tcp.port=10005
    """.stripMargin)

    val sparkMasterSystem = ActorSystem("SparkMaster", config)
    //创建启动master
    val masterRef = sparkMasterSystem.actorOf(Props[Master], "ActiveMaster")

    masterRef ! "start"
  }
}