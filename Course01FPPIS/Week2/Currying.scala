package Course01FPPIS.Week2

/**
  * Created by perra on 17-1-22.
  */
object Currying {

  def product(a: Int, b: Int)(f: Int => Int): Int = {
    if (a > b) 1
    else f(a) * product(a + 1, b)(f)
  }

  def factorial(a: Int): Int = {
    product(1, a)(x => x)
  }

  def mapReduce(a: Int, b: Int)(f: Int => Int, combine: (Int, Int) => Int, zero: Int): Int =
    if (a > b) zero
    else combine(f(a), mapReduce(a+1, b)(f, combine, zero))

  def product_2(a: Int, b: Int)(f: Int => Int): Int =
    mapReduce(a, b)(f, (x, y) => x * y, 1)

  def factorial_2(a: Int): Int =
    product_2(1, a)(x => x)
}
