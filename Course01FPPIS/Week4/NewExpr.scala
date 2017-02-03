package Course01FPPIS.Week4

/**
  * Created by perra on 17-2-3.
  */
trait NewExpr {

  def eval: Int = this match {
    case Number(n) => n
    case Sum(e1, e2) => e1.eval + e2.eval
  }

  def show(e: NewExpr): String = e match {
    case Number(x) => x.toString
    case Sum(l, r) => show(l) + " + "  + show(r)
  }

}

case class Number(n: Int) extends NewExpr
case class Sum(e1: NewExpr, e2: NewExpr) extends NewExpr

