package Course01FPPIS.Week2

import AnonymousExample._
import Currying._
import FixedPointFunc._

/**
  * Created by perra on 17-1-22.
  */
object Main extends App{

  //2.1
  println("square sum of [3, 5] = " + sum(3, 5)(x => x * x))

  //2.2
  println("more general square sum of [3, 5] = " + sum(3, 5)(x => x * x))
  println("square product of [3, 5] = " + product(3, 5)(x => x * x))
  println("factorial of 5 = " + factorial(5))

  //2.3
  //This is wrong, you should abstract more anonymous function for calculation!!!
  //println("the solution of pre-amount func = " + fixedPoint(0.0)(pow((1.0 / 1 + exp(x)), 2.0) => 0.25 * (9000 * x + 19000)))
  println("example = " + fixedPoint(x => 1 + x / 2)(0.0))
  println("sqrt of 2 = " + FixedPointFunc.sqrt(2.0))
  println("newSqrt of 2 = " + newSqrt(2.0))

  //2.5
  println("------------------")
  val x = new Rational(1, 2)
  val y = new Rational(2, 3)
  println("1/2 + 2/3 = " + x.add(y).toString())
  println("1/2 - 2/3 = " + x.sub(y).toString())

}
