package com.yulong.gof23.observer.pattern

class Conditions extends Observer {
  private var mTemperatrue: Float = _
  private var mPressure: Float = _
  private var mHumidity: Float = _

  def display(): Unit = {
    println("today mTemperatrue " + mTemperatrue)
    println("today mPressure " + mPressure)
    println("today mHumidity " + mHumidity)
  }

  override def update(mTemperatrue: Float, mPressure: Float, mHumidity: Float): Unit = {
    this.mTemperatrue = mTemperatrue
    this.mPressure = mPressure
    this.mHumidity = mHumidity
    display()
  }


}
