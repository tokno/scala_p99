def flatten(list: List[Any]): List[Any] = {
  list.foldRight(List.empty[Any])((x, xs) => {
    x match {
      case _: List[_] => flatten(x.asInstanceOf[List[Any]]) ++ xs
      case _ => x :: xs
    }
  })
}

val before = List(List(1, 1), 2, List(3, List(5, 8)))
val after = List(1, 1, 2, 3, 5, 8)

println(flatten(before) == after)
