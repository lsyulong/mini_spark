package com.yulong.gof23.observer.pattern

trait Observer {
  def update(mTemperature: Float, mPressure: Float, mHumdity: Float)
}
