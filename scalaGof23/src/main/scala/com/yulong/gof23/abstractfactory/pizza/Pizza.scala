package com.yulong.gof23.abstractfactory.pizza

abstract class Pizza {
  var name: String = _

  def prepare(): Unit

  def hongpei(): Unit = {
    println("pizza is hongpei!")
  }

  def zhizuo(): Unit = {
    println("pizzza is zhizuoing!")
  }

  def box(): Unit = {
    println("pizza is boxing!")
  }
}
