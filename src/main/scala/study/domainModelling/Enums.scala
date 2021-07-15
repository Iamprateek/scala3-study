package study.domainModelling

/*
The enum construct is a great way to model algebraic data types (ADTs) in Scala 3.
 */

enum CrustSize:
  case Small, Medium, Large

enum CrustType:
  case Thin, Thick, Regular

enum Topping:
  case Cheese, Pepperoni, BlackOlives, GreenOlives, Onions

// Natural Number ADT
enum Nat:
  case Zero
  case Succ(pred: Nat)

object Enums extends App{

  import CrustSize.*
  val currentCrustSize = Small

  // in match expression

  val pizzaOrder = currentCrustSize match
    case Small => "Small Size pizza"
    case Large => "Large Size pizza"
    case Medium => "Medium Size pizza"

  // If else expression

  if currentCrustSize == Small then "Small Size Pizza." else "Not small sized Pizza."

}
