package Course01FPPIS.Week3

import java.util.NoSuchElementException

/**
  * Created by perra on 17-1-25.
  */
class Nil[T] extends List[T] {

  def isEmpty = true

  def head: Nothing = throw new NoSuchElementException("Nil.head")

  def tail: Nothing = throw new NoSuchElementException("Nil.tail")

}
