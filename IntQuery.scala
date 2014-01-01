abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

import scala.collection.mutable.ArrayBuffer

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) { buf += x }
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int) { super.put(2 * x) }
}

// val queue  = new BasicIntQueue with Doubling
// queue.put(10)
// queue.put(20)

// println(queue.get)
// println(queue.get)

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) { super.put(x + 1) }
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) {
    if ( x >= 0 ) super.put(x)
  }
}

val queue2 = new BasicIntQueue with Filtering with Incrementing
queue2.put(-1)
queue2.put(0)
queue2.put(1)

println(queue2.get)
println(queue2.get)