package study.datatypes

object Datatypes extends App {
  /*
  Built in Datatypes are objects and operators and methods
   */

  val b: Byte = 1
  val i: Int = 1
  val l: Long = 1
  val s: Short = 1
  val d: Double = 2.0
  val f: Float = 3.0
  
  // with mentioning datatype, Implicitly assigned by compiler based on value  
  val i_ = 123   // defaults to Int
  val j_ = 1.0   // defaults to Double
  
  //  append the characters L, D, and F (and their lowercase equivalents) to numbers to specify that they are Long, Double, or Float

  val x = 1_000L   // val x: Long = 1000
  val y = 2.2D     // val y: Double = 2.2
  val z = 3.3F     // val z: Float = 3.3
  
  // Really Large Number usng Big Int
  
  val bi = BigInt(12343_12243_1223L)
  
  // Really large decimal with precision value using Big Decimal 
  
  val bd = BigDecimal(12_343.124_343_5) // <- underscore here are separators just to make long integers/decimals to be readable

  /*
  String and String Interpolation 
   */
  
  val superman = "Superman"
  val hope = 'S'
  
  val statement =
    """This love is taking its toll me 
      |I said good bye 
      |Too many times before
      |""".stripMargin
      
  println(s"I am ${superman} and the symbol '${hope}' stands for hope.")


  /*
    Type heirarchy
   */
  // Any : superclass of all types . Top type.
  // defines methods such as hashcode, equals, toString

  // Any(2) // <- cannot be called this way
  val any:Any = 1

  // any + 2 cannot happen as + is not a member of Any

  // Matchable : used to mark all types that we can perform pattern matching on
  // * It is important to guarantee a property call “parametricity”.
  // * In summary, it means that we cannot pattern match on values of type Any,  but only on values that are a subtype of Matchable



  // AnyVal represents value types and they are non-nullable*
  // children -> Double, Float, Long, Int, Short, Byte, Char, Unit, and Boolean


/*
  // Unit : () is a value type which carries no meaningful information
  In statement-based languages, void is used for methods that don’t return anything. If you write methods in Scala that have no return value, such as the following method, Unit is used for the same purpose
*/

  def printSomething():Unit = println("Something")

  /*
    AnyRef represents reference types
    All non-value types are defined as reference types.
    Every user-defined type in Scala is a subtype of AnyRef
       java.lan.object is equivalent to it

   */

  // BigInt and BigDecimal are of AnyRef and can null 
  val normalInteger : Int =  123
  val bigInteger:BigInt = 1234546576767788L

  val ss:BigInt = null
  val sss:Null = null 
  val anyVal:AnyVal = normalInteger
  val anyVal2:AnyRef = bigInteger

  println(anyVal2)
}
