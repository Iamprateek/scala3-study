###### Printing main returned Main$$$Lambda$3/1543727556@3930015a 

Wrote code like - 
```
object Main {
  def main(args: Array[String]): Unit = {
    println(main) // <- why ?
  }  
}
```

output : `Main$$$Lambda$3/1543727556@3930015a
`

Why is this happeninng ?
[ The reason is automatic eta expansion ](http://dotty.epfl.ch/docs/reference/changed-features/eta-expansion.html)

