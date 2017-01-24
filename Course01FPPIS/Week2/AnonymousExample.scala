package Course01FPPIS.Week2

/**
  * Created by perra on 17-1-22.
  */
object AnonymousExample {

  def sum(a: Int, b: Int)(f: Int => Int): Int = {

    //tail recursive
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, acc + f(a))
    }
    loop(a, 0)

  }

  def sum_2(a: Int, b: Int)(f: Int => Int) =
    if (a > b) 0
    else f(a) + sum(a + 1, b)(f)

}
