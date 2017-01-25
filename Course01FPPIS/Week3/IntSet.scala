package Course01FPPIS.Week3

/**
  * Created by perra on 17-1-25.
  */


abstract class IntSet {

  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet

}
