package study.topLevelDefinition

/*
In Scala 3, all kinds of definitions can be written at the “top level” of your source code files
 */

import scala.collection.mutable.ArrayBuffer

enum Topping:
  case Cheese, Pepperoni, Mushrooms

import Topping.*
class Pizza:
  val toppings = ArrayBuffer[Topping]()

val p = Pizza()

extension (s: String)
  def capitalizeAllWords = s.split(" ").map(_.capitalize).mkString(" ")

val hwUpper = "hello, world".capitalizeAllWords

type Money = BigDecimal

// more definitions here as desired ...

@main def myApp = //  this works like a main function. link : https://dotty.epfl.ch/docs/reference/changed-features/main-functions.html
  p.toppings += Cheese
  println("show me the code".capitalizeAllWords)

@main def myApp2 = // ,_ this works like a main function
  p.toppings += Cheese
  println("show me the code again".capitalizeAllWords)

@main def main1 =
  println("main1 printed something")

@main def main11 =
  println("main11 printed something")

object Main10 extends App {
  println("Main10 Executed !!".toUpperCase())
  main11
}

object Main2  {
  def main(args: Array[String]): Unit = {
    println("Main2 can run too !!".toUpperCase())
    Main10

  }


}