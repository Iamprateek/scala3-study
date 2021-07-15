package study.domainModelling

/*
  Classes
  Scala classes are used in OOP-style programming. Here’s an example of a class that models a “person.”
  In OOP fields are typically mutable, so firstName and lastName are both declared as var parameters
*/

class Person2(var firstName: String, var lastName: String):
  def printFullName() = println(s"$firstName $lastName")