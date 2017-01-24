package Course01FPPIS.Week1

/**
  * Created by perra on 17-1-20.
  */
object Sqrt {
  def abs(x: Double) =
    if (x > 0) x else -x

  //Version1

  //  def sqrtIter(guess: Double, x: Double): Double =
  //    if (isGoodEnough(guess, x)) guess
  //    else  sqrtIter(improve(guess, x), x)
  //
  //  def isGoodEnough(guess: Double, x: Double): Boolean =
  //    abs(guess * guess - x) < 0.001
  //
  //  def improve(guess: Double, x: Double) =
  //    (guess + x / guess) / 2
  //
  //  def sqrt(x: Double) =
  //    sqrtIter(1.0, x)

  //Version2 modify the small and large number
  //The problem is abs(guess * guess - x) < 0.001
  //左右两边的量纲不一样

  //  def sqrtIter(guess: Double, x: Double): Double =
  //    if (isGoodEnough(guess, x)) guess
  //    else  sqrtIter(improve(guess, x), x)
  //
  //  def isGoodEnough(guess: Double, x: Double): Boolean =
  //    abs(guess * guess - x) / x < 0.001
  //
  //  def improve(guess: Double, x: Double) =
  //    (guess + x / guess) / 2
  //
  //  def sqrt(x: Double) =
  //    sqrtIter(1.0, x)

  //Version3 Block and Scope

  def sqrt(x: Double) = {

    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else  sqrtIter(improve(guess))

    def isGoodEnough(guess: Double): Boolean =
      abs(guess * guess - x) / x < 0.001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtIter(1.0)

  }
}
