package graph

import scala.collection.mutable

object algo extends App {

  graph.numberOfVertex = 5
  graph.edges = Array.ofDim[Int](graph.numberOfVertex,graph.numberOfVertex)
  graph.edges(0)(0) = 0
  graph.edges(0)(1) = 1
  graph.edges(0)(2) = 1
  graph.edges(0)(3) = 0
  graph.edges(0)(4) = 0
  graph.edges(1)(0) = 1
  graph.edges(1)(1) = 0
  graph.edges(1)(2) = 0
  graph.edges(1)(3) = 1
  graph.edges(1)(4) = 1
  graph.edges(2)(0) = 1
  graph.edges(2)(1) = 0
  graph.edges(2)(2) = 0
  graph.edges(2)(3) = 0
  graph.edges(2)(4) = 0
  graph.edges(3)(0) = 0
  graph.edges(3)(1) = 1
  graph.edges(3)(2) = 0
  graph.edges(3)(3) = 0
  graph.edges(3)(4) = 0
  graph.edges(4)(0) = 0
  graph.edges(4)(1) = 1
  graph.edges(4)(2) = 0
  graph.edges(4)(3) = 0
  graph.edges(4)(4) = 0

  for(i <- 0 until graph.numberOfVertex) graph.vertexVisited += false

  println(s"BFS traversal results :" )
  graph.bfs()

  graph.vertexVisited = mutable.MutableList.empty
  for(i <- 0 until graph.numberOfVertex) graph.vertexVisited += false

  println(s"DFS traversal results :" )
  graph.dfs()
}
