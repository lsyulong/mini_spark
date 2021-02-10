package generic

object UpperBound {
  def main(args: Array[String]): Unit = {

    val float = new CommonCompare[java.lang.Float](10.1f, 20.1f)
    println(float.greater)
  }


}

class CommonCompare[T <: Comparable[T]](var1: T, var2: T) {
  def greater = if (var1.compareTo(var2) > 0) var1 else var2
}