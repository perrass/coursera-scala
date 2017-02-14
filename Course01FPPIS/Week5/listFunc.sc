object listFunc {
  val nums = List(2, -4, 5, 7, 1)
  val fruits = List("apple", "pineapple", "orange", "banana")

  nums filter (x => x > 0)
  nums filterNot (x => x > 0)
  nums partition (x => x > 0)

  nums takeWhile (x => x > 0)
  nums dropWhile (x => x > 0)
  nums span (x => x > 0)

  val data = List("a", "a", "a", "b", "c", "c", "a")

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case y :: ys =>
      val (first, rest) = xs span (z => z == y)
      first :: pack(rest)
  }

  pack(data)

  def encode[T](xs: List[T]): List[(T, Int)] =
      pack(xs) map (ys => (ys.head, ys.length))

  encode(data)

  def sum(xs: List[Int]) = (xs foldLeft 0)(_ + _)
  def product(xs: List[Int]) = (xs foldLeft 1)(_ * _)
  sum(nums)
  product(nums)

}