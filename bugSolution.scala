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

  // Solution: provide an implicit conversion for Double to Int
  implicit val doubleToInt: Double => Int = _.toInt
  val myDouble = new MyClass[Double](30.5)
  println(myDouble.myMethod)
}
```