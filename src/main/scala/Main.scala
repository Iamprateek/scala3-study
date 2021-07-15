
object Main {
  def main(args: Array[String]): Unit = {
    println(main) // <- why ?
  }
  
  def msg = "I was compiled by dotty :)"
  
  def wow(a:Int):Unit = {
    print(wow)
  } 
}
