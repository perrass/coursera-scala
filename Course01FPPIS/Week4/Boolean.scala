package Course01FPPIS.Week4

/**
  * Created by perra on 17-2-3.
  */
abstract class Booleans {
  def ifThenElse[T](t: => T, e: => T): T

  def && (x: => Booleans) =
    ifThenElse(x, false)

  def || (x: => Booleans) =
    ifThenElse(true, x)

  def unary_! =
    ifThenElse(false, true)

  def == (x: Booleans) =
    ifThenElse(x, x.unary_!)

  def != (x: Booleans) =
    ifThenElse(x.unary_!, x)

  def < (x: Booleans) =
    ifThenElse(false, x)
}
