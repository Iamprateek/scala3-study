package study.methods

/*
Method outside a class/object/trait. Why is this happening here .
 Answer in the link : https://dotty.epfl.ch/docs/reference/dropped-features/package-objects.html
 */
def met: Unit ={
  println("Method Outside")
}


object Method{

  def main(args: Array[String]): Unit = {
    met // this work !!

    def sum(a: Int, b: Int): Int = a + b

    // without return Type mentioned
    def concatenate(s1: String, s2: String) = s1 + s2

    // *** It is important to mention Types for parameters

    // here we can write a method in indented form as in python
    def multilinemethod(i:Int):String =
      i match
        case 1 => "One"
        case _ => "Not One"

    println(s"Indented styled method value : ${ multilinemethod(1)}")

    // Proper identation is needed now
    def multilinemethod2(i:Int):String = {
      i match
        case 1 => "One"
        case _ => "Not One"
    }

    println(s"Old styled method value : ${ multilinemethod2(0)}")

    // method with default value
    def makeConnection(url: String, timeout: Int = 5000): Unit =
      println(s"url=$url, timeout=$timeout")

    makeConnection("https://localhost")         // url=http://localhost, timeout=5000
    makeConnection("https://localhost", 2500)   // url=http://localhost, timeout=2500

    /*
    Named parameters are particularly useful when multiple method parameters have the same type.
    At a glance, with this method you may wonder which parameters are set to true or false:
        engage(true, true, true, false)

     More readable :
        engage(
          speedIsSet = true,
          directionIsSet = true,
          picardSaidMakeItSo = true,
          turnedOffParkingBrake = false
        )
     */

    /*
    Extension methods
      * Extension methods let you add new methods to closed classes.
        For instance, if you want to add two methods named hello and aloha to the String class, declare them as extension methods.
      In old scala we had to use implicits.... :(
     */


    extension (s: String)
    // parameterless methods
      def hello: String = s"Hello, ${s.capitalize}!"
      def aloha: String = s"Aloha, ${s.capitalize}!"

    println("world".hello)    // "Hello, World!"
    println("friend".aloha)   // "Aloha, Friend!"

    extension(s:String)
      def addNtimesOs(n:Int):String = s+ ("o"*3)

    println("yolo".addNtimesOs(3))
  }

}