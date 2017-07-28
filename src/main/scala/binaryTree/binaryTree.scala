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
        preOrder(n.left)
        preOrder(n.right)
      case _ =>
    }
  }

  def postOrder(root: Option[Node]): Unit ={
    root match {
      case Some(n) =>
        postOrder(n.left)
        postOrder(n.right)
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

  def delete(root: Node, delData: Int): Unit = {
    var curr: Option[Node] = Some(root)
    var parent: Option[Node] = Some(root)
    var isLeftChild = false

    while(curr.isDefined && curr.get.data != delData){

      parent = curr

      if(delData < curr.get.data){
        isLeftChild = true
        curr = curr.get.left
      } else {
        isLeftChild = false
        curr = curr.get.right
      }
    }

    if(curr.isDefined && curr.get.left.isEmpty && curr.get.right.isEmpty) {

      if (curr.get == root) () // root was node to be deleted
      else if (isLeftChild) parent.get.left = None
      else parent.get.right = None
    }

    if(curr.isDefined && curr.get.left.isDefined && curr.get.right.isEmpty) {

      if(isLeftChild) parent.get.left = curr.get.left
      else parent.get.right = curr.get.left
    }

    if(curr.isDefined && curr.get.right.isDefined && curr.get.left.isEmpty) {

      if(isLeftChild) parent.get.left = curr.get.right
      else parent.get.right = curr.get.right
    }

    if(curr.isDefined && curr.get.left.isDefined && curr.get.right.isDefined) {

      if(isLeftChild) parent.get.left = Some(getSuccessor(curr.get))
      else parent.get.right = Some(getSuccessor(curr.get))
    }
  }

  def getSuccessor(delNode: Node): Node = {

    var successorParent = delNode
    var successor = delNode
    var curr = delNode.right

    while(curr.isDefined){
      successorParent = successor
      successor = curr.get
      curr = curr.get.left
    }

    if(successor != delNode.right.get){
      successorParent.left = successor.right
      successor.right = delNode.right
    }

    successor
  }

}
