package Course01FPPIS.Week1

/**
  * Created by perra on 17-1-19.
  */
object Judge {

  def and(x: Boolean, y: Boolean) =
    if (x) y else false

  def or(x: Boolean, y: Boolean) =
    if (x) true else y

  //by name parameters

  def and_2(x: Boolean, y: => Boolean) =
    if (x) y else false
}
