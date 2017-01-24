package Course01FPPIS.Week2

import math.abs

/**
  * Created by perra on 17-1-23.
  * 数值解
  */
object FixedPointFunc {

  val tolerance = 0.0001
  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }

//  This function is not convergence, the result is jumping between 2 and 1
//  the solution is to average the jumping result.
//  def sqrt(x: Double) =
//    fixedPoint(1.0)(y => x / y)

  def sqrt(x: Double) =
    fixedPoint(y => (y + x / y) / 2)(1.0)

  def averageDamp(f: Double => Double)(x: Double) =
    (x + f(x)) / 2

  def newSqrt(x: Double) =
    fixedPoint(averageDamp(y => x / y))(1.0)

}
