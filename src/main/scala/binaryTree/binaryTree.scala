package binaryTree

case class Node(data: Int, var left: Option[Node], var right: Option[Node])

object Node {

  def inOrder(root: Option[Node]): Unit ={
    root match {
      case Some(n) =>
        inOrder(n.left)
        println(n.data)
        inOrder(n.right)
      case _ =>
    }
  }

  def preOrder(root: Option[Node]): Unit ={
    root match {
      case Some(n) =>
        println(n.data)
        inOrder(n.left)
        inOrder(n.right)
      case _ =>
    }
  }

  def postOrder(root: Option[Node]): Unit ={
    root match {
      case Some(n) =>
        inOrder(n.left)
        inOrder(n.right)
        println(n.data)
      case _ =>
    }
  }

 def search(root: Node, sData: Int): Boolean = {

   root.data match {
     case d if d == sData => true
     case d if sData < d && root.left.isDefined=> search(root.left.get, sData)
     case d if sData > d && root.right.isDefined=> search(root.right.get, sData)
     case _ => false
   }
 }

  def add(root: Node, nData: Int): Node = {

    root.data match {
      case d if nData < d && root.left.isEmpty => {
        root.left = Some(Node(nData, None, None))
        root
        }
      case d if nData < d && root.left.isDefined => add(root.left.get, nData)
      case d if nData >= d && root.right.isEmpty => {
        root.right = Some(Node(nData, None, None))
        root
        }
      case d if nData >= d && root.right.isDefined => add(root.right.get, nData)
    }
  }

}
