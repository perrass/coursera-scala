import scala.collection.GenMap

object randomGenerator {
//  import java.util.Random
//  val rand = new Random
  trait Generator[+T] {
    self =>  // an alias for this

    def generate: T

    def map[S](f: T => S): Generator[S] = new Generator[S] {
      def generate = f(self.generate) // using self not this
//      def generate = f(Generator.this.generate)
    }

    def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
      def generate = f(self.generate).generate
    }
  }

  val integers = new Generator[Int] {
    val rand = new java.util.Random
    def generate = rand.nextInt()
  }

  val booleans = new Generator[Boolean] {
    def generate = integers.generate > 0
  }

  // To avoid new Generator
  // map is required to be defined, and then for-expression can be used

  val booleans2 = for (x <- integers) yield x > 0

  val boolean3 = integers map (x => x > 0)

  def pairs[T, U](t: Generator[T], u: Generator[U]) = for {
    x <- t
    y <- u
  } yield (x, y)

  def pairs2[T, U](t: Generator[T], u: Generator[U]) =
    t flatMap (x => u map (y => (x, y)))

}