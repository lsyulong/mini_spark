package com.yulong.gof23.abstractfactory.pizza

class PepperPizza extends Pizza {
  override def prepare(): Unit = {
    println(this.name + "PepperPizza is prepareing!")
  }
}
