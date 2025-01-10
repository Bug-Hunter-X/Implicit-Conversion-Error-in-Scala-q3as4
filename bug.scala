```scala
class MyClass[T](val value: T) {
  def myMethod(implicit ev: T => Int): Int = ev(value)
}

object Main extends App {
  implicit val intToInt: Int => Int = identity
  val myInt = new MyClass[Int](10)
  println(myInt.myMethod)

  implicit val stringToInt: String => Int = _.toInt
  val myString = new MyClass[String]("20")
  println(myString.myMethod)

  // This will cause a compilation error because no implicit conversion from Double to Int exists.
  val myDouble = new MyClass[Double](30.5)
  println(myDouble.myMethod) 
}
```