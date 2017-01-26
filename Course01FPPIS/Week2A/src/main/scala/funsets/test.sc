object test {
  type Set = Int => Boolean

  def contains(s: Set, elem: Int): Boolean = s(elem)

  def singletonSet(elem: Int): Set =
    (x: Int) => x == elem

  singletonSet(1)(1)

  def union(s: Set, t: Set): Set =
    (x: Int) => s(x) || t(x)
  def intersect(s: Set, t: Set): Set =
    (x: Int) => s(x) && t(x)
  def diff(s: Set, t: Set): Set =
    (x: Int) => s(x) && (!t(x))

  def filter(s: Set, p: Int => Boolean): Set =
    (x: Int) => s(x) && p(x)

  //The difference of union and filter???

  val bound = 1000

  /**
    * Returns whether all bounded integers within `s` satisfy `p`.
    */
  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a > bound) true
      else if (s(a) && !p(a)) false
      else iter(a + 1)
    }
    iter(-bound)
  }
}