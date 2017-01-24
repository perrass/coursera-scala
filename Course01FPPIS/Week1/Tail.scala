package Course01FPPIS.Week1

/**
  * Created by perra on 17-1-20.
  */
object Tail {

  def factorial(n: Int) = {

    def go(acc: Int, n: Int): Int =
      if (n == 0) acc
      else go(acc * n, n - 1)

    go(1, n)

  }
}
