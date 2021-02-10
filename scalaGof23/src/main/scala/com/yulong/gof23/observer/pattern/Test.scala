package com.yulong.gof23.observer.pattern


object Test {
  def main(args: Array[String]): Unit = {

    val conditions = new Conditions()
    val weatherData = new WeatherData()
    weatherData.registerObserver(conditions)
    weatherData.setData(500, 20, 120)

  }
}
