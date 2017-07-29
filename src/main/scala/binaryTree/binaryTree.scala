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

  def delete(root: Option[Node], dData:Int): Node = {

    var currNode: Option[Node] = root
    var parentNode: Option[Node] = None
    var isLeftChild: Boolean = false
    var rootNode : Node = root.get

    while (currNode.isDefined && dData != currNode.get.data) {
      parentNode = currNode
      dData match {
        case x if x < currNode.get.data =>
          isLeftChild = true
          currNode = currNode.get.left
        case x if x > currNode.get.data =>
          isLeftChild = false
          currNode = currNode.get.right
        case _ =>
      }
    }

    if (currNode.isDefined && currNode.get.left.isEmpty && currNode.get.right.isEmpty)
      isLeftChild match {
        case true if parentNode.isDefined => parentNode.get.left = None
        case false if parentNode.isDefined => parentNode.get.right = None
        case _ => 
      }


    if (currNode.isDefined && currNode.get.left.isEmpty && currNode.get.right.nonEmpty)
      isLeftChild match {
        case true if parentNode.isDefined => parentNode.get.left = currNode.get.right
        case false if parentNode.isDefined => parentNode.get.right = currNode.get.right
        case _ => 
      }


    if (currNode.isDefined && currNode.get.left.isEmpty && currNode.get.left.nonEmpty)
      isLeftChild match {
        case true if parentNode.isDefined => parentNode.get.left = currNode.get.left
        case false if parentNode.isDefined => parentNode.get.right = currNode.get.left
        case _ => 
      }


    if (currNode.isDefined && currNode.get.left.nonEmpty && currNode.get.right.nonEmpty) {
      val successor = findSuccessor(currNode.get)
      parentNode match {
        case Some(x) if isLeftChild => x.left = Some(successor)
        case Some(x) => x.right = Some(successor)
        case _ => rootNode = successor
      }
    }
    rootNode
  }

  def findSuccessor(delNode: Node): Node = {
    var successorParent = delNode
    var successor = delNode
    var currentNode = delNode.right

    while(currentNode.isDefined){
      successorParent = successor
      successor = currentNode.get
      currentNode = currentNode.get.left
    }

    if(successor != delNode.right.get){
      successorParent.left = successor.right
      successor.right = delNode.right
    }
    successor.left = delNode.left
    successor
  }

}
