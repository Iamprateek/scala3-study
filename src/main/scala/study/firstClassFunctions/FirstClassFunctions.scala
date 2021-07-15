package study.firstClassFunctions

/*
  Lambdas (anonymous functions) :
  Higher-order functions (HOFs) : That takes a function as param or returns a function
  Immutable collections in the standard library
 */
object FirstClassFunctions extends App{

  // Map in list is Higher order function and in it 'i => i * 2' is anonymous function
  val a = List(1, 2, 3).map(i => i * 2)   // List(2,4,6)
  val b = List(1, 2, 3).map(_ * 2)        // List(2,4,6)

  // this is also converted to a lambda,

  def sayWow(name:String) =  s"Wow ${name} !!!"
  println(s"the type of sayWow method is : ${sayWow}")
  // Reason : automatic eta expansion (http://dotty.epfl.ch/docs/reference/changed-features/eta-expansion.html)

  // map and foreach(reducer)
  val c = List("Rocket", "StarLord", "Gamora").map( "I want to say, " + sayWow(_)).foreach(println)

  /*
  Immutable collections
    When you work with immutable collections like List, Vector, and the immutable Map and Set classes,
    it’s important to know that these functions don’t mutate the collection they’re called on;
    instead, they return a new collection with the updated data.
    As a result, it’s also common to chain them together in a “fluent” style to solve problems.
  */
}
