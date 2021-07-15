package study.scalaCollections


object ScalaCollections extends App {

  /* Lists : Sequential collection having a head and rest list as tail
        Good for data where most of the ops happen at the head
   */
  // Creating list
  val list1 = List(1,2,3,4)
  val list2 = (1 to 4).toList
  val list3 = (1 to 9 by 2).toList
  val list4 = (1 until 5).toList
  val list5 = List.range(1,5)
  val list6 = List.range(1,10,2)

  val list7 = List(10,20,30,40,10)

  // list methods
  println(s"dropping first two values list7.drop(2) = ${list7.drop(2)}")
  println(s"dropping values while it less than 20 list7.dropWhile(_<=20) = ${list7.dropWhile(_<=20)}")
  println(s"filtering values less than 25 list7.filter(_ < 25) = ${list7.filter(_ < 25)}")
  println(s"taking a slice of values from list from index 2 till before  index 4  list7.slice(2,4) = ${list7.slice(2,4)}")
  println(s"head of the list, list7.head = ${list7.head}")
  println(s"tail of the list, list7.tail = ${list7.tail}")
  println(s"take first 3 in the list, list7.take(3) = ${list7.take(3)}")
  println(s"take while value less than 30 list7.takeWhile(_ < 30) = ${list7.takeWhile(_ < 30)}")

  // flattening example
  println(s"List(List(1,2), List(3,4)).flatten = ${List(List(1,2), List(3,4)).flatten}")

  // map and flatmap

  val nums = List("one", "two")

  // map applies a function mentioned
  println(s" applyinh map on ${nums}, nums.map(_.toUpperCase) = ${nums.map(_.toUpperCase)}")

  // flatmap applies a function mentioned and flattens the container values
  println(s" applying flatMap on ${nums}, nums.flatMap(_.toUpperCase) = ${nums.flatMap(_.toUpperCase)}")

  // reduce
  println(s"(1 to 5).toList.reduce(_+_) = ${(1 to 5).toList.reduce(_+_)}")

  // fold -  reduce with initial Value
  println(s"(1 to 5).toList.fold(100)(_+_) = ${(1 to 5).toList.fold(100)(_+_)}")

  /*
  Tuple :
     is a type that lets you easily put a collection of different types in the same container
     are of like Tuple1 till Tuple22 and there is TupleXXl
   */

  val t1 = Tuple3(1, "two", List('t','h','r','e','e'))

  // no need to declare, put in parens and it automatically finds out
  val t2 = (1, "two", List('t','h','r','e','e'))

  // accessing them in this way , new way in scala
  println(s" values in a tuple can be accessed as t2(0) : ${t2(0)}  also as t2._1 : ${t2._1}")

 /*
 In scala 3 :
   The limits of 22 for... the maximal number of fields in tuple types have been dropped...
   tuples beyond Tuple22 are erased to a new trait scala.TupleXXL
  */
  println(s"class of tuple greater than 22 (1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1) is " +
    s"${
    (1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1).getClass
  }")

}
