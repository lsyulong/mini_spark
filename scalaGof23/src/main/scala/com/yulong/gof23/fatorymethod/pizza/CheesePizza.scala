package com.yulong.gof23.fatorymethod.pizza

class CheesePizza extends Pizza {
  override def prepare(): Unit = {

    println(this.name + "CheesePizza is prepareing!")
  }
}
