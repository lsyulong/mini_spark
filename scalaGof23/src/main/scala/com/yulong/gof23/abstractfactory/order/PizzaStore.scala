package com.yulong.gof23.abstractfactory.order

object PizzaStore {
  def main(args: Array[String]): Unit = {

    new OrderPizza(new BJFactory)
  }
}
