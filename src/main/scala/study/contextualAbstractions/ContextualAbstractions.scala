package study.contextualAbstractions

// sample case class address

case class Address(city:String, street:String)

/*
  Under certain circumstances, you can omit some parameters of method calls that are considered repetitive.
  Those parameters are called Context Parameters
  because they are inferred by the compiler from the context surrounding the method call.
 */
object ContextualAbstractions extends App{
  val addresses:List[Address] = List(
    Address("new york", "nowhere"),
    Address("new york", "anywhere"),
    Address("new york", "nowhere"),
    Address("london", "baker"),
    Address("london", "bekar")
  )

  // sorts a list of addresses by two criteria: the city name and then street name.

  // addresses.sortBy(address => (address.city, address.street))

  println(s"addresses.sortBy(address => (address.city, address.street)) : " +
    s"${addresses.sortBy(address => (address.city, address.street))}")

  /*
  The sortBy method takes a function that returns, for every address, the value to compare it with the other addresses. In this case, we pass a function that returns a pair containing the city name and the street name.

  Note that we only indicate what to compare, but not how to perform the comparison. How does the sorting algorithm know how to compare pairs of String?

  Actually, the sortBy method takes a second parameter—a context parameter—that is inferred by the compiler. It does not appear in the above example because it is supplied by the compiler.

  This second parameter implements the how to compare. It is convenient to omit it because we know Strings are generally compared using the lexicographic order.

  However, it is also possible to pass it explicitly
   */

  println(s"addresses.sortBy(address => (address.city, address.street))(using Ordering.Tuple2(Ordering.String, Ordering.String)): " +
    s"${addresses.sortBy(address => (address.city, address.street))(using Ordering.Tuple2(Ordering.String, Ordering.String))}")

  /*
  Contextual Abstractions are used to avoid repetition of code. They help developers write pieces of code that are extensible and concise at the same time.
   */
}
