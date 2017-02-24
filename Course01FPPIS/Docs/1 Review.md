1 FPPIS Review
===

**case class**

Case classes are Scala's preferred way to define complex data

	abstract class JSON
	case class JSeq(elems: List[JSON]) extends JSON
	case class JObj(bindings: Map[String, JSON]) extends JSON
	case class JNum(num: Double) extends JSON
	case class JStr(str: String) extends JSON
	case class JBool(b: Boolean) extends JSON
	case class JNull extends JSON
	
This structure is also appropriate for pattern matching

**Pattern matching in map**

**What is the type of `{ case (key, value) => key + ": " + value }`**

---

**variance**

	trait Function1[-A, +R] {
		def apply(x: A): R
	}
	
Say `C[T]` is a parameterized type and A, B are types such that `A <: B`

Type	      | Name			| Scala
-------------|---------------------|-----------
C[A] <: C[B] | C is covariant（协变变量)	|class C[+A]
C[A] >: C[B] | C is contravariant (逆变变量)   |class C[-A]
Or	      | C is nonvariant	|class C[A]
	
**Question**

	type A = IntSet => NonEmpty
	type B = NonEmpty => IntSet
	
which is true?

	A <: B
	B <: A
	
或者说A是大到小，B是小到大，大到小一定是小到大的subtype，对`=>`的左边来说，A的左边是大，超出B的范围（可以定义更多属性）；从右边来说，B的右边是大，A的方法一定是B的方法的子集，所以A是B的subtype

**Hence**

If `A1 >: A2` and `B1 <: B2`, then `A1 => B1 <: A2 => B2`

其实，这个的核心是方法集B, `if B1 <: B2`, then `A1 => B1 <: A2 => B2`, 和A的方法无关，如果`A1 <: A2`, `B1 <: B2`，那么为什么要有type A ??? (**WRONG!!!!!!!!**)

**Hence**

Functions are **contravariant** in their argument type(s) and **covariant** in their result type

	trait Function1[-T, +U]

	A2 => B2
	A1 => B1
	
A2的argument可以传递到A1，因为A2 <: A1; B1的方法一定能在B2实现，因为B1 <: B2

**Hence**

上面标有**WRONG!!!!!!!!**的说法一定是错误的，因为如果A1 <: A2, 那么A2的argument传递到A1的时候可能会报错！！！！１！

**E.g**

`List[+A]` is covariant, 因为List有Con和Nil，Con是List[A], Nil是Nothing，Nothing是A的subtype，所以需要List是Covariant


---


**map flatMap filter foldLeft foldRight implementation**

	abstract class List[T] {
		def map[U](f: T => U): List[U] = this match {
			case Nil => this
			case x :: xs => f(x) :: xs.map(f)
		}
		
		def filter(p: T => Boolean): List[T] = this match {
			case Nil => this
			case x :: xs => if (p(x)) x :: xs.filter(p) else xs.filter(p)
		}
		
		def foldLeft[U](z: U)(op: (U, T) => U): U = this match {
			case Nil => z
			case x :: xs => (xs foldLeft op(z, x))(op)
		}
		def foldRight[U](z: U)(op: (T, U) => U): U = this match {
			case Nil => z
			case x :: xs => op(x, (xs foldRight z)(op))
		}
	}
	
**Difference between foldLeft and foldRight**

	def concat[T](xs: List[T], ys: List[T]): List[T] = 
	(xs foldRight ys)(_ :: _)
	
but if we used foldLeft, the tail in one elem (U, T) => U is T, the type of T is not a List, and :: is not applicable