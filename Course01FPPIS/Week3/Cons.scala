package Course01FPPIS.Week3

/**
  * Created by perra on 17-1-25.
  */
class Cons[T](val head: T, val tail: List[T]) extends List[T] {

  def isEmpty = false

}
