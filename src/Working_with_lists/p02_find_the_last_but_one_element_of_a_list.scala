def penultimate[A](list: List[A]): A = {
  list.apply(list.length - 2)
}

println(penultimate(List(1, 1, 2, 3, 5, 8)))

