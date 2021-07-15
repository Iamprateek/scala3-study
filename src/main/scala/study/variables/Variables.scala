package study.variables

object Variables extends App {
  
  //Immutable 
  val x  = 0
  // x = 1 // <- compilation error for reassignment
  
  // Mutable 
  var y = 0 
  y = 1 // <- reassignment possible 
  
//  looking like dynamic type
  val a = 0
  val b = "Box"
  val c = List(1,2,4)
  val d = (1, "Box", List(1,2,4))
  
//  static type look. ecplicilty declaring datatype 
  val a_staticTyped:Int = 0
  val b_staticTyped:String = "Box"
  val c_staticTyped:List[Int] = List(1,2,4) // [] in list are used to specify conatained values datatype
  val d_staticTyped:Tuple3[Int, String, List[Int]] = (1, "Box", List(1,2,4)) // [] in list are used to specify conatained values datatype
  
  
}
