import math.sqrt

implicit class P35(self: Int) {
  // 最小の素因数を返す
  private def minPrimeFactor: Int = {
    val limit = sqrt(self).asInstanceOf[Int]

    (2 to limit)
      .find(self % _ == 0)
      .getOrElse(self)
  }

  def primeFactors: List[Int] = {
    self match {
      case 0 => List()
      case 1 => List(1)
      case _ => {
        val factor = minPrimeFactor
        val quotient = (self / factor)

        if (2 < quotient)
          factor :: quotient.primeFactors
        else
          List(factor)
      }
    }
  }
}

assert(1.primeFactors == List(1))
assert(11.primeFactors == List(11))
assert(315.primeFactors == List(3, 3, 5, 7))
assert(9999.primeFactors == List(3, 3, 11, 101))
assert(32154.primeFactors == List(2, 3, 23, 233))
assert(987654321.primeFactors == List(3, 3, 17, 17, 379721))
