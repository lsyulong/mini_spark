package com.yulong.gof23.single

class SingleTon private() {

}

object SingleTon {
  private var s: SingleTon = null

  def getInstance = {
    if (s == null) {
      s = new SingleTon
    }
    s
  }
}

object TestSingleTon {
  def main(args: Array[String]): Unit = {
    val single1 = SingleTon.getInstance
    val single2 = SingleTon.getInstance
    if (single1 == single2) println(true)
  }
}