object Element {
  class ArrayElement(
    val contents: Array[String]
    ) extends Element {
  }

  class LineElement(s: String) extends Element {
    val contents = Array(s)
    override val width = s.length
    override val height = 1

  }

  class UniformElement(
    ch: Char,
    override val width: Int,
    override val height: Int
    ) extends Element {
    private val line = ch.toString * width
    val contents = Array.fill(height)(line)
  }

  def elem(contents: Array[String]): Element =
    new ArrayElement(contents)

  def elem(chr: Char, width: Int, height: Int): Element =
    new UniformElement(chr, width, height)

  def elem(s: String): Element =
    new LineElement(s)
}

abstract class Element {
  val contents: Array[String]
  val height = contents.length
  val width = if (height == 0) 0 else contents(0).length

  def above(that: Element): Element = {
    Element.elem(this.contents ++ that.contents)
  }

  def beside(that: Element): Element = {
    Element.elem(
      for ( (line1, line2) <- this.contents zip that.contents )
        yield line1 + line2
      )
  }

  override def toString = contents mkString "\n"
}

