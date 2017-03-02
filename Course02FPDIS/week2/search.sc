object search {
  def isPrime(n: Int): Boolean = {
    val sqrtN = Math.sqrt(n).asInstanceOf[Int]
    (2 until sqrtN) forall (x => n % x != 0)
  }

  def secondPrime(n1: Int, n2: Int): Int = {
    assert (n2 >= n1)
    ((n1 to n2) filter isPrime)(1)
  }

  def secondPrime2(from: Int, to: Int) =
    nthPrime(from, to, 2)

  def nthPrime(from: Int, to: Int, n: Int): Int = {
    if (from >= to) throw new Error("no prime")
    else if (isPrime(from))
      if (n == 1) from else nthPrime(from + 1, to, n - 1)
    else nthPrime(from + 1, to, n)
  }

  secondPrime(149, 200)
  secondPrime2(149, 200)

  def expr = {
    val x = { print("x"); 1 }
    lazy val y = { print("y"); 2 }
    def z = { print("z"); 3 }
    z + y + x + z + y + x
  }
  expr

  def z = { print("z"); 3}
  z
  val x = { print("x"); 1}
  x
}