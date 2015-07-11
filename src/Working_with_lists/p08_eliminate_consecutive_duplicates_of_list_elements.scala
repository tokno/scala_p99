def compress[A](list: List[A]): List[A] = list match {
    case List() => list
    case _ => list.foldLeft(list.head :: Nil)((xs, x) => {
      if (xs.last == x)
        xs
      else
        xs :+ x
    })
}

val before = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
val after = List('a, 'b, 'c, 'a, 'd, 'e)

println(compress(before)  == after)
