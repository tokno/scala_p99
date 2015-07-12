sealed abstract class Tree[+T] {
  def size: Int
}

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  override def toString = "T(%s %s %s)".format(value, left, right)
  override def size = left.size + right.size + 1
}
case object End extends Tree[Nothing] {
  override def toString = "."
  override def size: Int = 0
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}

// solve
object Tree {
  def cBalanced[T](depth: Int, value: T): Tree[T] = depth match {
    case 0 => Node(value)
    case 1 => Node(value, Node(value), Node(value))
    case _ => Node(value, cBalanced(depth - 1, value), cBalanced(depth - 1, value))
  }
}

assert(Tree.cBalanced(0, "x").size == 1)
assert(Tree.cBalanced(1, "x").size == 3)
assert(Tree.cBalanced(2, "x").size == 7)
assert(Tree.cBalanced(3, "x").size == 15)
assert(Tree.cBalanced(4, "x").size == 31)
assert(Tree.cBalanced(5, "x").size == 63)

println(Tree.cBalanced(0, "x"))
println(Tree.cBalanced(1, "x"))
println(Tree.cBalanced(2, "x"))
println(Tree.cBalanced(3, "x"))
println(Tree.cBalanced(4, "x"))
