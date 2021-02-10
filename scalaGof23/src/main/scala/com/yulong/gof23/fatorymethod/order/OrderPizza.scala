package com.yulong.gof23.fatorymethod.order

import com.yulong.gof23.fatorymethod.pizza.Pizza

import scala.io.StdIn
import scala.util.control.Breaks._

abstract class OrderPizza {
  var order_type: String = _
  var pizza: Pizza = _
  breakable {
    do {
      order_type = StdIn.readLine()
      pizza = createPizza(order_type)
      if (pizza == null) {
        break()
      }
      this.pizza.prepare()
      this.pizza.zhizuo()
      this.pizza.hongpei()
      this.pizza.box()
    } while (true)
  }

  def createPizza(order_type: String): Pizza
}
