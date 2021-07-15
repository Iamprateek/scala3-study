package study.domainModelling

// ways to create class of various types
// var fields are used to describe variable field,
// when declariring a param as var field, we be get and setter
//class Person(var name: String, var vocation: String)
class Book(var title: String, var author: String, var year: Int)
class Movie(var name: String, var director: String, var year: Int)


// Classes can also have methods and additional fields that are not part of constructors. They are defined in the body of the class. The body is initialized as part of the default constructor:

class Person3(var firstName: String, var lastName: String):

  println("initialization begins")
  val fullName = firstName + " " + lastName

  // a class method
  def printFullName: Unit =
  // access the `fullName` field, which is created above
    println(fullName)

// there can be default parameters in Scala

class Socket(val timeout: Int = 5_000, val linger: Int = 5_000):
  override def toString = s"timeout: $timeout, linger: $linger"

/*
  Auxiliary constructors
  You can define a class to have multiple constructors so consumers of your class can build it in different ways.
 */

import java.time.*

// [1] the primary constructor
class Student(
               var name: String,
               var govtId: String
             ):
  private var _applicationDate: Option[LocalDate] = None
  private var _studentId: Int = 0

  // [2] a constructor for when the student has completed
  // their application
  def this(
            name: String,
            govtId: String,
            applicationDate: LocalDate
          ) =
    this(name, govtId)
    _applicationDate = Some(applicationDate)

  // [3] a constructor for when the student is approved
  // and now has a student id
  def this(
            name: String,
            govtId: String,
            studentId: Int
          ) =
    this(name, govtId)
    _studentId = studentId
object Classes extends App {
  val someone = Person2("Foo", "Bar") // no need of writing new as we do in Scala 2

  println(Person2.apply("as", "adss")) // <- class has inbuilt apply method now
// https://docs.scala-lang.org/scala3/reference/other-new-features/creator-applications.html

  val someBook = Book("harry potter", "JK rowling", 2001)

//  can read a value
  println(someBook.title)
  // can set var fields
  someBook.year = 2012
  someBook.year_=(2021) // internally a setter is there that looks like this
  println(someBook.year)


}
