package com.yulong.gof23.abstractfactory.pizza

class GreekPizza extends Pizza {
  override def prepare(): Unit = {
    println(this.name + "GreekPizza is prepareing!")
  }
}
