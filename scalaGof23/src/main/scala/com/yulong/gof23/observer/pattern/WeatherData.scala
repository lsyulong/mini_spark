package com.yulong.gof23.observer.pattern


import scala.collection.mutable.ListBuffer

class WeatherData extends Subject {

  private var mTemperatrue: Float = _
  private var mPressure: Float = _
  private var mHumidity: Float = _
  private var mObservers: ListBuffer[Observer] = ListBuffer()

  def getTemperatrue() = {
    mTemperatrue
  }

  def getPressure() = {
    mPressure
  }

  def getHumidity() = {
    mHumidity
  }

  def getDataChange() = {
    notifyObserver()
  }

  def setData(mTemperatrue: Float, mPressure: Float, mHumidity: Float): Unit = {
    this.mTemperatrue = mTemperatrue
    this.mPressure = mPressure
    this.mHumidity = mHumidity
    getDataChange()
  }

  override def registerObserver(o: Observer): Unit = {
    mObservers.append(o)
  }

  override def removeObserver(o: Observer): Unit = {
    if (mObservers.contains(o)) mObservers -= o
  }

  override def notifyObserver(): Unit = {
    for (o <- mObservers) {
      o.update(mTemperatrue, mPressure, mHumidity)
    }
  }
}
