// implicitクラスとfor式

implicit class SetOperation[A](self: List[A]) {
  // Ruby Array#repeated_permutaion風
  def repeatedPermutation(size: Int): List[List[A]] = size match {
    case 0 => List()
    case 1 => self.map((v) => List(v))
    case _ => for {
       x <- self
      xs <- repeatedPermutation(size - 1)
    } yield x :: xs
  }
}

def gray(length: Int): List[String] = {
  List(0, 1)
    .repeatedPermutation(length)
    .map(_.mkString(""))
}

assert(List(0, 1).repeatedPermutation(0) == List())
assert(List(0, 1).repeatedPermutation(1) == List(List(0), List(1)))
assert(List(0, 1).repeatedPermutation(2) == List(List(0, 0), List(0, 1), List(1, 0), List(1, 1)))

val result = List("000", "001", "010", "011", "100", "101", "110", "111")
assert(gray(3) == result)
