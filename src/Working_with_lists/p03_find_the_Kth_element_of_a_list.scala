def nth[A](n: Int, list: List[A]): A = {
  list.apply(n)
}

println(nth(2, List(1, 1, 2, 3, 5, 8)))
