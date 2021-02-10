package generic

object EnglishClass {
  def main(args: Array[String]): Unit = {
    val list1 = List("hehe", "haha", "2")
    val list2 = List(1, 2, 3)
    println(list1(2))
    println(myList(list1))
    println(myList(list2))
  }

  def myList[E](lst: List[E]): E = {
    lst(lst.length / 2)
  }
}