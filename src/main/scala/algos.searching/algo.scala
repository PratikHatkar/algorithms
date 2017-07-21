package algos.searching

object algo extends App {

  val arr = List(6,7,9,12,24)

  println(s"binary search output - ${ binary.search(arr, 120, 0, arr.length-1)}")

}
