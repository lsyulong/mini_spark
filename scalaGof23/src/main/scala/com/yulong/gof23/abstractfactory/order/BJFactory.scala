package com.yulong.gof23.abstractfactory.order

import com.yulong.gof23.abstractfactory.pizza.{CheesePizza, GreekPizza, PepperPizza, Pizza}

class BJFactory extends AbstractFactory {
  override def createPizza(order_type: String): Pizza = {
    var pizza: Pizza = null
    if ("cheese" == order_type) {
      pizza = new CheesePizza
    } else if ("greek" == order_type) {
      pizza = new GreekPizza
    } else if ("pepper" == order_type) {
      pizza = new PepperPizza
    }
    pizza
  }
}
