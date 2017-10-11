package pratikHashMap

class Node[K,V](var key: K, var value: V, var next: Node[K,V] = null)

class FakeHashMap[K,V](var a:Array[Node[K, V]] = Array.ofDim[Node[K,V]](256)){

  def newHash(key: K) = Math.abs(key.hashCode()) % 256

  def get(k: K): Option[V] = {
    a(newHash(k)) match {
      case n: Node[K, V] => {
          var curr: Node[K,V] = n
          while(curr !=  null) {
            if(curr.key == k) return Some(curr.value)
            else curr = curr.next
          }
        None
      }
      case _ => None
    }
  }

  def put(k: K, v: V): Boolean = {
    val nHash = newHash(k)
    if(a(nHash) == null) a(nHash) = new Node(k,v)
    else {
      var prev: Node[K,V] = null
      var curr = a(nHash)
      while(curr !=  null) {
        if( curr.key == k){
          curr.value = v
          return true
        }
        prev = curr
        curr = curr.next
      }
      prev.next = new Node(k,v)
    }
    true
  }

  def delete(k: K): Boolean = {
    a(newHash(k)) match {
      case n: Node[K, V] => {
        var prev: Node[K,V] = null
        var curr: Node[K,V] = n
        while(curr !=  null) {
          if(curr.key == k) {
            if(prev == null) a(newHash(k)) = a(newHash(k)).next
            else prev.next = curr.next
            return true
          }
          prev = curr
          curr = curr.next
        }
        false
      }
      case _ => false
    }
  }
}

object Solution extends App {

  val p = new FakeHashMap[String, Int]()
  println(p.put("p", 1))
 println(p.put("Jaitashree", 2))
  println(p.get("p"))
  println(p.get("Jaitashree"))
  println(p.put("Jaitashree", 3))
  println(p.get("Jaitashree"))
  println(p.delete("p"))
  println(s"node key: ${p.a(112)}")
  println(s"node key: ${p.a(158).key}   value: ${p.a(158).value}")

}