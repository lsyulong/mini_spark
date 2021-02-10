package generic


object Message {
  def main(args: Array[String]): Unit = {
    //    val int = new IntMessage[Int](10)
    //    val string = new StringMessage[String]("hehenigetou")
    //    new EnglishClass[SeasonEnum.SeasonEnum, String, String](SeasonEnum.spring, "hehe", "高级")
//    val clas1 = new EnglishClass[SeasonEnum.SeasonEnum, String, String](SeasonEnum, "hehe", "高级")
//    println(clas1.classSeason, clas1.className, clas1.classType)

  }
}

abstract class Message[T](s: T) {
  def get = s
}

class IntMessage[Int](v: Int) extends Message(v)

class StringMessage[String](v: String) extends Message(v)


//class EnglishClass[A, B, C](val classSeason: A, val className: B, val classType: C)
//
//class SeasonEnum extends Enumeration {
//  type SeasonEnum = Value
//  val spring, autum, summer, winter = Value
//}