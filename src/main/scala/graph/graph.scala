package graph

import scala.collection.mutable

object graph {
  var numberOfVertex = 0
  var edges = Array.ofDim[Int](numberOfVertex,numberOfVertex)
  var vertexVisited = mutable.MutableList.empty[Boolean]


  def bfs(): Unit = {
    val q = mutable.Queue.empty[Int]
    vertexVisited(0) = true
    println(0)
    q.enqueue(0)

    while(q.nonEmpty){
      val v1: Int = q.dequeue()
      while(getAdjustedVisited(v1).isDefined){
        val v2 = getAdjustedVisited(v1).get
        vertexVisited(v2) = true
        println(v2)
        q.enqueue(v2)
      }
    }
  }

  def dfs(): Unit = {
    val s = mutable.Stack[Int]()
    vertexVisited(0) = true
    println(0)
    s.push(0)

    while(s.nonEmpty){
      val v1 = getAdjustedVisited(s.top)
      if(v1.isDefined){
        vertexVisited(v1.get) = true
        println(v1.get)
        s.push(v1.get)
      }
      else s.pop()
    }
  }

  def getAdjustedVisited(v: Int): Option[Int] = {
    var res: Option[Int] = None
    for(i <- 0 until numberOfVertex) {
      if(edges(v)(i) == 1 && !vertexVisited(i)) {
        res = Some(i)
        return res
      }
    }
    res
  }

}
