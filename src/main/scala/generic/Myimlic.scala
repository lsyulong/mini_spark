package generic

object Myimlic {
  implicit def per2Per(p: Person1) = new Ordered[Person1] {
    override def compare(that: Person1): Int = {
      p.age - that.age
    }
  }
}

