package com.yulong.gof23.fatorymethod.pizza

class PepperPizza extends Pizza {
  override def prepare(): Unit = {
    println(this.name + "PepperPizza is prepareing!")
  }
}
