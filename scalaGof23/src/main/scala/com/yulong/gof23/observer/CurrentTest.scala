package com.yulong.gof23.observer

object CurrentTest {
  def main(args: Array[String]): Unit = {

    val conditions = new CurrentConditions()
    val weatherData = new WeatherData(conditions)
    weatherData.setData(30,20,120)
  }
}


