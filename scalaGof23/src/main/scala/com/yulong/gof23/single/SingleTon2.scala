package com.yulong.gof23.single

class SingleTon2 private() {

}

object SingleTon2 {
  private val s: SingleTon2 = new SingleTon2

  def getInstance = s
}

object TestSingleTon2 {
  def main(args: Array[String]): Unit = {
    val single1 = SingleTon2.getInstance
    val single2 = SingleTon2.getInstance
    if (single1 == single2) println(true)
  }
}