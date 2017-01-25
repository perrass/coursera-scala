package Course01FPPIS.Week3

/**
  * Created by perra on 17-1-25.
  */
trait List[T] {

  def isEmpty: Boolean
  def head: T
  def tail: List[T]

}
