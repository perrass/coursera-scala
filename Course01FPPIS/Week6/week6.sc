import math.sqrt

object test {

  val xs = Array(1, 2, 3, 44)
  xs map (x => x * 2)

  val s = "Hello World"
  s filter (c => c.isUpper)

  s exists (c => c.isUpper)
  s forall (c => c.isUpper)

  val pairs = List(1, 2, 3) zip s
  pairs unzip

  s flatMap (c => List('.', c))

  def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
    (xs zip ys).map(xy => xy._1 * xy._2).sum

  // pattern matching

  def scalarProduct2(xs: Vector[Double], ys: Vector[Double]): Double =
    (xs zip ys).map{ case (x, y) => x * y }.sum

  def isPrime(n: Int): Boolean = {
    val sqrtN = sqrt(n).asInstanceOf[Int]
    (2 until sqrtN) forall (d => n % d != 0)
  }

  isPrime(23977)

  val n = 7
//  val xss = (1 until n) map (i => (1 until i) map (j => (i, j)))
//  val res2 = ((1 until n) map (i => (1 until i) map (j => (i, j)))).flatten
//  val res2 = (1 until n) flatMap (i => (1 until i) map (j => (i, j)))
//  val res3 = res2 filter (pair => isPrime(pair._1+ pair._2))

  def scalarProduct(xs: List[Double], ys: List[Double]): Double = {
    (for ((x, y) <- xs zip ys) yield x * y).sum
  }

}