implicit class P31(self: Int) {
  def isPrime: Boolean = self match {
    case 1 | 2 => true
    case _ => {
      val limit = self / 2
      (2 to limit).forall((n) => {
        self % n != 0
      })
    }
  }
}

assert(1.isPrime)
assert(2.isPrime)
assert(3.isPrime)
assert(!4.isPrime)
assert(5.isPrime)
assert(!6.isPrime)
assert(7.isPrime)
assert(!8.isPrime)
assert(!9.isPrime)
assert(!10.isPrime)
assert(11.isPrime)
assert(!12.isPrime)
assert(13.isPrime)
assert(!14.isPrime)
assert(!15.isPrime)
