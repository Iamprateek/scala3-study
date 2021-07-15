package study.objects

/*
  The object keyword creates a Singleton object.
  Put another way, an object defines a class that has exactly one instance.


  * They are used to create collections of utility methods.
  * A companion object is an object that has the same name as the class it shares a file with. In this situation, that class is also called a companion class.
  * They’re used to implement traits to create modules.
 */


// object to store utility methods
object StringUtils:
  def isNullOrEmpty(s:String):Boolean = s==null || s.trim.isEmpty
  def leftTrim(s:String):String = s.replaceAll("^\\s+", "")
  def rightTrim(s:String):String = s.replaceAll("\\s+$", "")

/*
  Companion objects
    A companion class or object can access the private members of its companion.
    Use a companion object for methods and values which aren’t specific to instances of the companion class.
  */
// Class with companion object can be put inside an object/class , woah !!!!
import scala.math.*

class Circle(radius: Double):
  import Circle.*
  def area: Double = calculateArea(radius)

object Circle:
  private def calculateArea(radius: Double): Double =
    Pi * pow(radius, 2.0)


/*
  Creating modules from traits
  * Objects can also be used to implement traits to create modules.
 */
trait AddService:
  def add(a: Int, b: Int) = a + b

trait MultiplyService:
  def multiply(a: Int, b: Int) = a * b

// implement those traits as a concrete object
object MathService extends AddService, MultiplyService



object Objects extends App {
  val circle1 = Circle(5.0)
  println(s"Companion Object  ${circle1.area}")

  println(s"running object extending trait of add service: ${MathService.add(3,4)}")
}
