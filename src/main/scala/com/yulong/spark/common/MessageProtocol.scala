package com.yulong.spark.common

/**
  * worker注册信息
  *
  * @param id
  * @param cpu
  * @param ram
  */
case class RegisterWorkerInfo(id: String, cpu: Int, ram: Int)

class WorkerInfo(val id: String, val cpu: Int, val ram: Int) {
  var lastHeartBeat: Long = 0
}

case object RegisterWorkerInfo

/**
  * worker向master定时发送心跳信息
  */
case object SendHeartBeat

case class HeartBeat(id: String)

//定时监测超时worker
case object StartTimeOutWorker

//
case object RemoveTimeOutWorker