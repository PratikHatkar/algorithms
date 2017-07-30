package linkedList

object algo extends App {

  Link.insertLast(Link(1))
  Link.insertLast(Link(2))
  Link.insertLast(Link(3))
  Link.insertLast(Link(4))

  println("Original Linked list : ")
  Link.display()

  println(s"Search Linked list for 3: ${Link.search(3).get.data}")

  println(s"Search Linked list for 15: ${Link.search(15).getOrElse("Not Found")}")

  println("Delete 3")
  Link.delete(3)
  Link.display()

  println("Reverse Linked list : ")
  Link.reverse()
  Link.display()


  println("Delete first")
  Link.deleteFirst()
  Link.display()

  println("Delete last")
  Link.deleteLast()
  Link.display()

  println("Delete 2")
  Link.delete(2)
  Link.display()

  println("Adding Links : ")
  Link.insertFirst(Link(3))
  Link.insertFirst(Link(2))
  Link.insertFirst(Link(1))
  Link.display()

}
