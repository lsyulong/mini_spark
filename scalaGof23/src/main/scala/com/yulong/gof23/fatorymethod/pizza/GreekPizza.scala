package com.yulong.gof23.fatorymethod.pizza

class GreekPizza extends Pizza {
  override def prepare(): Unit = {
    println(this.name + "GreekPizza is prepareing!")
  }
}
