import Math._

/*
 * ユークリッドの互除法
 * https://ja.wikipedia.org/wiki/%E3%83%A6%E3%83%BC%E3%82%AF%E3%83%AA%E3%83%83%E3%83%89%E3%81%AE%E4%BA%92%E9%99%A4%E6%B3%95
 *
 * 1. 入力を m, n (m ≧ n) とする。
 * 2. n = 0 なら、 m を出力してアルゴリズムを終了する。
 * 3. m を n で割った余りを新たに n とし、更に 元のnを新たにm とし 2. に戻る。
 */

def euclideanAlgorithm(m: Int, n: Int): Int = n match {
  case 0 => m
  case _ => euclideanAlgorithm(n, m % n)
}

def gcd(n1: Int, n2: Int) = euclideanAlgorithm(max(n1, n2), min(n1, n2))

assert(gcd(36, 63) == 9)
assert(gcd(1071, 1029) == 21)
