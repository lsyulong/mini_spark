package generic

object ViewBound {
  def main(args: Array[String]): Unit = {

    val p = new Person1("tom", 30)
    val p1 = new Person1("jack", 10)
    //    val conn = new CommonCompare1(20, 40)
    //    println(conn.greater)
    import Myimlic._
    val con = new CommonCompare1(p, p1)
    println(con.greater.name)
  }


}

class CommonCompare1[T <% Ordered[T]](var1: T, var2: T) {
  def greater = if (var1.compareTo(var2) > 0) var1 else var2
}

class Person1(val name: String, val age: Int)
