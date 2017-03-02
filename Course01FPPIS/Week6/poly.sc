object poly {
  class Poly(terms0: Map[Int, Double]) {
    def this(bindings: (Int, Double)*) = this(bindings.toMap)

    val terms = terms0 withDefaultValue 0.0

    def adjust(term: (Int, Double)): (Int, Double) = {
      val (exp, coeff) = term
      exp -> (coeff + terms(exp))
    }

    def + (other: Poly) = new Poly(terms ++ (other.terms map adjust))

    override def toString = {
      (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString " + "
    }
  }

  val p1 = new Poly(1 -> 2.0, 3 -> 4.0)

}