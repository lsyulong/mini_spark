package com.yulong.spark.worker

import java.util.UUID

import akka.actor.{Actor, ActorSelection, ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import com.yulong.spark.common.{HeartBeat, RegisterWorkerInfo, SendHeartBeat}

import scala.concurrent.duration._

/**
  * spark worker endpoint
  */
class Worker(host: String, port: Int) extends Actor {

  val workerId = UUID.randomUUID().toString
  var masProxy: ActorSelection = _

  override def preStart(): Unit = {
    masProxy = context.actorSelection("akka.tcp://SparkMaster@127.0.0.1:10005/user/ActiveMaster")
  }

  override def receive: Receive = {
    case "start" => {
      println("worker is starting !!!")
      masProxy ! RegisterWorkerInfo(workerId, 4, 4)
    }
    case RegisterWorkerInfo => {
      println(s"worker ($workerId)  register successful")
      //定时向自己发送心跳信息
      import context.dispatcher
      context.system.scheduler.schedule(0 millis, 3000 millis, self, SendHeartBeat)
    }
    case SendHeartBeat => {
      println(s"worker($workerId) 发送心跳")
      masProxy ! HeartBeat(workerId)
    }

  }
}

object Worker {

  def main(args: Array[String]): Unit = {

    val config = ConfigFactory.parseString(
      s"""
         |akka.actor.provider="akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname="127.0.0.1"
         |akka.remote.netty.tcp.port=10006
    """.stripMargin)

    val sparkWorkerSystem = ActorSystem("SparkWorker", config)
    //创建启动worker
    val workerRef = sparkWorkerSystem.actorOf(Props(new Worker("127.0.0.1", 10005)), "Worker01")

    workerRef ! "start"

  }
}