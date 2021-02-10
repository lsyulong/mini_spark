package com.yulong.gof23.abstractfactory.order

import com.yulong.gof23.abstractfactory.pizza.Pizza

import scala.io.StdIn
import scala.util.control.Breaks._

class OrderPizza {
  var abstractFactory: AbstractFactory = _
  var order_type: String = _
  var pizza: Pizza = _

  def this(abstractFactory: AbstractFactory) = {
    this
    breakable {
      do {
        order_type = StdIn.readLine()
        pizza = abstractFactory.createPizza(order_type)
        if (pizza == null) {
          break()
        }
        this.pizza.prepare()
        this.pizza.zhizuo()
        this.pizza.hongpei()
        this.pizza.box()
      } while (true)
    }
  }

}
