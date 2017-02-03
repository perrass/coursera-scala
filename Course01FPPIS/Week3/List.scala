package Course01FPPIS.Week3

/**
  * Created by perra on 17-1-25.
  */
trait List[+T] {

  def isEmpty: Boolean
  def head: T
  def tail: List[T]

  //4.4 variance
  //def prepend(elem: T): List[T] = new Cons(elem, this)
  def prepend[U >: T](elem: U): List[U] = new Cons(elem, this)
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {

  def isEmpty = false

}

//class Nil[T] extends List[T] {
//
//  def isEmpty = true
//
//  def head: Nothing = throw new NoSuchElementException("Nil.head")
//
//  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
//
//}

object Nil extends List[Nothing] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object List {
  //List()
  def apply[T]() = Nil
  //List(1)
  def apply[T](x: T): List[T] = new Cons(x, Nil)
  // List(1, 2) = List.apply(1, 2)
  def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, Nil))
}

object test {
  val x: List[String] = Nil
  def f(xs: List[NonEmpty], x: Empty): List[IntSet] = xs prepend x
}
