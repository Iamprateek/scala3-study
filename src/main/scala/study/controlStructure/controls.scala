package study.controlStructure

object controls extends App{

  val x = 0
  /*
    If else : completely different syntax in Scala 3
    - it is an expression
   */

  // this will return Unit
  val ifWithPrint =  if x < 0 then
    println("negative")
  else if x == 0 then
    println("zero")
  else
    println("positive")

  println(s"print in is statement returns ${ifWithPrint}")


  /*
  Expression oriented programming
  * When every expression you write returns a value, that style is referred to as expression-oriented programming, or EOP.

  * Conversely, lines of code that don’t return values are called statements, and they’re used for their side-effects.
    in scala Unit () is returned when we call something a side effect
   */

  // Expression
  val expressiveValue : Int = if true then 1 else 0  // 1


  // side effect
  val sideEffectValue = println("") // ()


  /*
  An expression returns a result, while a statement does not.
  Statements are typically used for their side-effects, such as using println to print to the console.
   */

  /*
  For loops and expressions
    * The for keyword is used to create a for loop. This example shows how to print every element in a List
   */

  val ints = List(1, 2, 3, 4, 5)

  for i <- ints do println(s"Plain for loop : ${i}")

  /*
  The code i <- ints is referred to as a generator,
  and the code that follows the do keyword is the body of the loop
  if you leave the parentheses off of the generator, the do keyword is required before the code that follows it
  */

  // GUARDS in for loop
  for i <- ints if i%2  == 0 do println(s"For loop with Guards (even Value) : ${i}")

  // Multiple Generators and guards in single for loop
  for
    i <- 1 to 3
    j <- 'a' to 'c'
    if i == 2
    if j == 'b'
  do
    println(s"For loop with multple Generator and Guards(Version 1)  i = $i, j = $j")

    for
    i <- 1 to 3 if i == 2
    j <- 'a' to 'c' if j == 'b'
    do
      println(s"For loop with multple Generator and Guards(Version 2)  i = $i, j = $j")

    for
    i <- 1 to 3  ; j <- 'a' to 'c'
    if i == 2;  if j == 'b'
    do
      println(s"For loop with multple Generator and Guards(Version 3)  i = $i, j = $j")

/*  For Expression
 * using yield keyword instead of do, you create for expressions which are used to calculate and yield results
 *
*/

  val doubles = for i <- ints yield i * 2

  println(s"For expression doubles result : ${doubles}")

  for i <- (1 to 5) yield i+8 // returns data of type vector val res0: IndexedSeq[Int] = Vector(9, 10, 11, 12, 13)

  (1 to 5) // range collection , val res1: scala.collection.immutable.Range.Inclusive = Range 1 to 5


  // \|/ Assignment returns unit type too
  println(s"#Interesting : assignment expression result value : ${val doubles = for i <- ints yield i * 2}")


  // for loop with curly braces

  val oddeven = for {i <- ints}
    yield {
      i match {
        case _ if i%2 == 0 => "Even"
        case _ if i%2 == 1 => "Odd"
      }
    }

    println(s"For expression oddeven result : ${oddeven}")

  // we can also use for yield with guards

  val fruits = List("Apple", "Banana", "Cherry", "Grape", "Tomato", "Pineapple", "Kiwi")

  val bigNamedFruits = for f <- fruits if f.size > 5 yield f

  println(s"For expression with guards : ${bigNamedFruits}")

  /*
  Match Expressions :
  match really is an expression, meaning that it returns a result based on the pattern match, which you can bind to a variable

  A match expression can be used to test a variable against many different types of patterns.

  There is matchable trait who is chile of Any and parent of AnyRef and AnyVal. Reason being introduction of immutable Array iArray.

  */

  import scala.annotation.switch

  val i = 5
  val day = (i : @switch) match
    case 0 => "Sunday"
    case 1 => "Monday"
    case 2 => "Tuesday"
    case 3 => "Wednesday"
    case 4 => "Thursday"
    case 5 => "Friday"
    case 6 => "Saturday"
    case _ => "invalid day"

  /*
    When writing simple match expressions like this, it’s recommended to use the @switch annotation on the variable i.
    This annotation provides a compile-time warning if the switch can’t be compiled to a tableswitch or lookupswitch, which are better for performance.

    for knowing about switches in Java : read answer from stack overflow -

    https://stackoverflow.com/questions/338206/why-cant-i-use-switch-statement-on-a-string/338230#338230

    */

  def getClassAsString(x: Matchable): String = x match
    case s: String => s"'$s' is a String"
    case i: Int => "Int"
    case d: Double => "Double"
    case l: List[_] => "List"
    case _ => "Unknown"

  // examples
  println(s"mactch expression : ${getClassAsString(1)}")               // Int"
  println(s"mactch expression : ${getClassAsString("hello")}")
  println(s"mactch expression : ${getClassAsString(List(1, 2, 3))}")

  /*
  Using the default value
    When you need to access the catch-all, default value in a match expression, just provide a variable name on the left side of the case statement,
    and then use that variable name on the right side of the statement as needed
   */
  val whatDay = (i : @switch) match
    case 0 => "Sunday"
    case 1 => "Monday"
    case 2 => "Tuesday"
    case 3 => "Wednesday"
    case 4 => "Thursday"
    case 5 => "Friday"
    case 6 => "Saturday"
    case what => s"i do not know what ${what} day is"

/*
  Handling multiple possible matches on one line
  * As mentioned, match expressions have many capabilities. This example shows how to use multiple possible pattern matches in each case statement:
*/

  val evenOrOdd = i match
    case 1 | 3 | 5 | 7 | 9 => println("odd")
    case 2 | 4 | 6 | 8 | 10 => println("even")
    case _ => println("some other number")

  /*
  If guards in cmatch expressions
  You can also use guards in the cases of a match expression.
   */

  val guarded = i match
    case 1 => println("one, a lonely number")
    case x if x == 2 || x == 3 => println("two’s company, three’s a crowd")
    case x if x > 3 => println("4+, that’s a party")
    case _ => println("i’m guessing your number is zero or less")

  /*
  CASE CLASSES AND MATCH EXPRESSIONS
You can also extract fields from case classes—and classes that have properly written apply/unapply methods—and use those in your guard conditions.
   */

  case class Person(name:String)

  val helloHi = Person("John") match
    case Person(n) if n == "Casey" => s"Yo ${n}"
    case Person(m) if m == "John" => s"Hello ${m}"
    case Person(o) => s"Hi ${o} !!!"

  /*
  MATCH EXPRESSIONS SUPPORT MANY DIFFERENT TYPES OF PATTERNS
      There are many different forms of patterns that can be used to write match expressions. Examples includes:

      Constant patterns (such as case 3 => )
      Sequence patterns (such as case List(els : _*) =>)
      Tuple patterns (such as case (x, y) =>)
      Constructor pattern (such as case Person(first, last) =>)
      Type test patterns (such as case p: Person =>)
   */
  def pattern(x: Matchable): String = x match

    // constant patterns
    case 0 => "zero"
    case true => "true"
    case "hello" => "you said 'hello'"
    case Nil => "an empty List"

    // sequence patterns
    case List(0, _, _) => "a 3-element list with 0 as the first element"
    case List(1, _*) => "list, starts with 1, has any number of elements"
    case Vector(1, _*) => "vector, starts w/ 1, has any number of elements"

    // tuple patterns
    case (a, b) => s"got $a and $b"
    case (a, b, c) => s"got $a, $b, and $c"

    // constructor patterns
    case Person(first) => s"Alexander, first name = $first"
    case Person("Zeus") => "found a dog named Zeus"

    // type test patterns
    case s: String => s"got a string: $s"
    case i: Int => s"got an int: $i"
    case f: Float => s"got a float: $f"
    case a: Array[Int] => s"array of int: ${a.mkString(",")}"
    case as: Array[String] => s"string array: ${as.mkString(",")}"
    case d: Person => s"dog: ${d.name}"
    case list: List[?] => s"got a List: $list"
    case m: Map[?, ?] => m.toString

    // the default wildcard pattern
    case _ => "Unknown"

  /*
   try/catch/finally
   * Scala’s try/catch/finally control structure lets you catch exceptions.
   * It’s similar to Java, but its syntax is consistent with match expressions
 */

  val t:Int = 1

  val triedValue:String = try
    t match // <- returns value or throws error
      case 1 => "Good"
      case _ => throw NumberFormatException("issue")

  catch // <- returns value
    case nfe: NumberFormatException => "Got a NumberFormatException."
    case _ => "Got some Exception."
  finally // <- only side effect
    println("Clean up your resources here.")

  println(s"try catch statement : ${triedValue}")

/*
    while loops
    Scala also has a while loop construct. It’s one-line syntax looks like this
*/

  var v = 0

  while v < 10 do
    println(s"While loop Value : ${v}")

}


