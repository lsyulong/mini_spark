package com.yulong.gof23.abstractfactory.pizza

class CheesePizza extends Pizza {
  override def prepare(): Unit = {

    println(this.name + "CheesePizza is prepareing!")
  }
}
