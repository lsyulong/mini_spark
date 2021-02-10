package com.yulong.gof23.observer

class WeatherData {
  private var mTemperatrue: Float = _
  private var mPressure: Float = _
  private var mHumidity: Float = _
  private var mCurrentConditions: CurrentConditions = _

  def this(mCurrentConditions: CurrentConditions) {
    this
    this.mCurrentConditions = mCurrentConditions
  }

  def getTemperatrue() = {
    mTemperatrue
  }

  def getPressure() = {
    mPressure
  }

  def getHumidity() = {
    mHumidity
  }

  def getDataChange(): Unit = {
    mCurrentConditions.update(getTemperatrue(), getPressure(), getHumidity())
  }

  def setData(mTemperatrue: Float, mPressure: Float, mHumidity: Float): Unit = {
    this.mTemperatrue = mTemperatrue
    this.mPressure = mPressure
    this.mHumidity = mHumidity
    getDataChange()
  }

}
