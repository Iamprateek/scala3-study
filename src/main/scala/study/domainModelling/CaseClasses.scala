package study.domainModelling

 /*
Case classes
The Scala case class lets you model concepts with immutable data structures. A case class has all of the functionality of a class, and also has additional features baked in that make them useful for functional programming. When the compiler sees the case keyword in front of a class it has these effects and benefits:
  * Case class constructor parameters are public val fields by default, so the fields are immutable, and accessor methods are generated for each parameter.
  * An unapply method is generated, which lets you use case classes in more ways in match expressions.
  * A copy method is generated in the class. This provides a way to create updated copies of the object without changing the original object.
    equals and hashCode methods are generated to implement structural equality.
  * A default toString method is generated, which is helpful for debugging.
  * You can manually add all of those methods to a class yourself, but since those features are so commonly used in functional programming, using a case class is much more convenient.
  */
 case class Person(
                    name: String,
                    vocation: String
                  )
object CaseClasses extends App {

  val p = Person("Reginald Kenneth Dwight", "Singer")

  // print its value using to String
  println(s"Value of persoon p = ${p}")
  println(s"Value of persoon p.toString = ${p.toString}")

  println( s"Name of the person : ${p.name} and the type is ${p.name.getClass }")

  val elton = p.copy(name = "Elton John")

  println(s"he is ${elton}")


}
