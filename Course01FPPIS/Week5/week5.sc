import math.Ordering

object week5 {
  val fruit = List("apples", "oranges", "pears")
  val num = List(1, 2, 3)
  val diag3 = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
  val empty = List()

  def last[T](xs: List[T]): T = xs match {
    case List() => throw new Error("last of empty list")
    case List(x) => x
    case y :: ys => last(ys)
  }

  def init[T](xs: List[T]): List[T] = xs match {
    case List() => throw new Error("init of empty list")
    case List(x) => List()
    case y :: ys => y :: init(ys)
  }

  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List() => ys
    case z :: zs => z :: concat(zs, ys)
  }

  def reverse[T](xs: List[T]): List[T] = xs match {
    case List() => xs
    case y :: ys => reverse(ys) ++ List(y)
  }

  def removeAt[T](n: Int, xs: List[Int]) = {
    (xs take n) ::: (xs drop n + 1)
  }

//  def flatten(xs: List[Any]): List[Any] = xs match {
//    case List() => xs
//    case List(y) => y
//    case y :: ys => y :: flatten(ys)
//  }
//
//  flatten(List(List(1, 1), 2, List(3, List(5, 8))))

  def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n =xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (ord.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

      val (fst, snd) = xs splitAt n
      merge(msort(fst), msort(snd))
    }
  }

  val nums = List(2, -4, 5, 7, 1)
  msort(nums)

  val fruits = List("Orange", "Apple", "Banana")
  msort(fruits)

  def scaleList(xs: List[Double], factor: Double): List[Double] = xs match {
    case Nil => xs
    case y :: ys => y * factor :: scaleList(ys, factor)
  }

  def scaleList2(xs: List[Double], factor: Double): List[Double] =
    xs map (x => x * factor)

  def squareList(xs: List[Int]): List[Int] = xs match {
    case Nil => xs
    case y :: ys => y * y :: squareList(ys)
  }

  def squareList2(xs: List[Int]): List[Int] =
    xs map (x => x * x)


}