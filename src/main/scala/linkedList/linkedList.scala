package linkedList

case class Link(data: Int, var next: Option[Link] = None)

object Link {

  var first: Option[Link] = None

  def insertFirst(newLink: Link): Option[Link] = {
    newLink.next = first
    first = Some(newLink)
    first
  }

  def insertLast(newLink: Link) ={
    var temp = first

    if(temp.isDefined){
      while(temp.get.next.isDefined){
        temp = temp.get.next
      }

      temp.get.next = Some(newLink)

    }
    else first = Some(newLink)
  }

  def deleteFirst(): Option[Link] = {

    val temp = first
    first = first.get.next
    temp
  }

  def deleteLast(): Unit = {

    var previous = first
    var curr = first
    while(curr.get.next.isDefined){
      previous = curr
      curr = curr.get.next
    }
    previous.get.next = None
  }

  def display(): Unit = {
    var curr = first
    if(curr.isDefined){
      while(curr.nonEmpty){
        println(curr.get.data)
        curr = curr.get.next
      }
    }
    else println("Linked list is Empty")
  }

  def search(key: Int): Option[Link] = {

    var curr = first
    while(curr.isDefined && curr.get.data != key){
      curr.get.next match {
        case Some(l) => curr = l.next
        case _ => None
      }
    }
    curr
  }

  def delete(key: Int) = {
    var curr = first
    var previous = first

    if (curr.isDefined && curr.get.data == key) first = first.get.next
    else {
      while (curr.get.data != key) {
        curr.get.next match {
          case Some(l) => {
            curr = l.next
            previous = Some(l)
          }
          case _ => None
        }
      }
      previous.get.next = curr.get.next
    }
  }

  def reverse(link: Option[Link] = first): Unit = {
    link match {
      case Some(curr) if curr.next.isEmpty => first = Some(curr)
      case Some(curr) => {
        reverse(curr.next)
        curr.next.get.next = Some(curr)
        curr.next = None
      }
      case _ =>
    }
  }

}