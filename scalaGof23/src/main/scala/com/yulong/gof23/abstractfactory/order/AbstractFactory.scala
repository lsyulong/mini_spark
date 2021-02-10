package com.yulong.gof23.abstractfactory.order

import com.yulong.gof23.abstractfactory.pizza.Pizza

trait AbstractFactory {
  def createPizza(order_type: String): Pizza
}
