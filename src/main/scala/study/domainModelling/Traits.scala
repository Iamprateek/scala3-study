package study.domainModelling

object Traits extends App {
  /*
    Scala traits can be used as simple interfaces,
    but they can also contain abstract and concrete methods and fields,
    and they can have parameters, just like classes.

    Great way to organize behaviours in small units.

  */

  trait Speaker {
    def speak(): String
  }
  trait Orator {
    def speak(): String = "Hello, I am orator"
  }
  // Writing in a different way as in Scala3
  trait Motivator:
    def speak(): String = "Hello, I am motivator"

  case class Person(name:String) extends Motivator, Orator{
    override def speak() = s"Hohoho, i am ${name}"
  }

  println(Person("person").speak())
}