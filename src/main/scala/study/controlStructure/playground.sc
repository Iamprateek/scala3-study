println(

 try{
   throw Exception("something ")
 }
  catch{
    case e:Exception => 2
  }
  finally {
    println("wow something happened !")
  }
)