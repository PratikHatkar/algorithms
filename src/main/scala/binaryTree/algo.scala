package binaryTree

object algo extends App {

  var root = Node(5, None, None)

  //adding node with data = 7
  Node.add(root, 7)
  //adding node with data = 2
  Node.add(root, 2)
  //adding node with data = 13
  Node.add(root, 13)

  println(s"inOrder")
  Node.inOrder(Some(root))
  println(s"preOrder")
  Node.preOrder(Some(root))
  println(s"postOrder")
  Node.postOrder(Some(root))

  println(s"binary search tree output for node with data 7 - ${ Node.search(root, 7)}")
  println(s"binary search tree output for node with data 2 - ${ Node.search(root, 2)}")
  println(s"binary search tree output for node with data 11 - ${ Node.search(root, 11)}")
  println(s"binary search tree output for node with data 13 - ${ Node.search(root, 13)}")

}
