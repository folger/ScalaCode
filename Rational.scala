class Rational(n: Int, d: Int) {
  require(d != 0)

  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  def this(n: Int) = this(n, 1)
  override def toString = numer + "/" + denom

  def +(that: Rational) =
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  def *(that: Rational) =
    new Rational(numer * that.numer, denom * that.denom)

  private def gcd(a: Int, b: Int): Int = 
    if ( b == 0 ) a else gcd(b, a % b)
}

import scala.language.implicitConversions

implicit def intToRational(n: Int) = new Rational(n)

val r1 = new Rational(1,2)
val r2 = new Rational(1,3)
val r3 = new Rational(3)
println(r1 * 10)

