package com.yulong.spark

import scala.math._

object Test {
  def main(args: Array[String]): Unit = {

    //    val lst = List(Some(10), Some(20), None)
    //    println(mySum(lst))

    //    val h = compose(f, g)
    //    println(h(10))
    //    println(h(40))
    //    println(values((x: Int) => x * x, -5, 5))
    //    val max_val = largest(x => 10 * x - x * x, 1 to 10)
    //    println(max_val)

    //    val lines = List("come on han hello", "come on han aaa aaa hello come ddd")
    //    val res = lines.flatMap((x: String) => x.split(" "))
    //      .map((s: String) => (s, 1))
    //      .groupBy((s: (String, Int)) => s._1)
    //      .map((s: (String, List[(String, Int)])) => (s._1, s._2.size))
    //    println(res)
    //    println(res.toList.sortBy((x:(String,Int)) =>x._2).reverse)
  }

  //  def mySum(list: List[Option[Int]]) = list.map((x: Option[Int]) => (x.getOrElse(0))).sum

  def mySum(list: List[Option[Int]]) = list.map(_.getOrElse(0)).sum

  def f(x: Double) = if (x > 0) Some(sqrt(x)) else None

  def g(x: Double) = if (x != 1) Some(1 / x - 1) else None

  def compose(f: Double => Option[Double], g: Double => Option[Double]) = {
    (x: Double) => {
      if (f(x) == None || g(x) == None) None else g(x)
    }
  }

  def values(func: Int => Int, low: Int, high: Int) = {
    var new_list = List[(Int, Int)]()
    low to high foreach {
      s => new_list = (s, func(s)) :: new_list
    }
    new_list
  }

  def largest(func: Int => Int, inputs: Seq[Int]) = {
    //    inputs.map((n: Int) => func(n)).max
    inputs.map(func(_)).max
  }
}
