package generic

object TestUpperBound {
  def main(args: Array[String]): Unit = {

    biophon(Seq(new Bird, new Bird))
    biophon(Seq(new Animal, new Animal))
    biophon(Seq(new Animal, new Bird))
    //    biophon(Seq(new Earth, new Earth))
  }

  def biophon[T <: Animal](things: Seq[T]): Unit = things map (_.sound)
}

class Earth {
  def sound(): Unit = {
    println("hello")
  }
}

class Animal extends Earth {
  override def sound(): Unit = {
    println("animal sound ")
  }
}

class Bird extends Animal {
  override def sound(): Unit = {
    println("bird sound ")
  }
}