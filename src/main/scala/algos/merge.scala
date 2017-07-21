package algos

import scala.collection.mutable

object merge {

  def sort(arr: Array[Int]): Array[Int] = {

    if(arr.length <= 1)
      return arr

    val (leftArr, rightArr) = arr.splitAt(arr.length / 2)

    val leftSorted = sort(leftArr)
    val rightSorted = sort(rightArr)

    merge(leftSorted, rightSorted)

  }

  def merge(leftArr: Array[Int], rightArr: Array[Int]): Array[Int] = {
    var left = leftArr
    var right = rightArr

    var leftHead, rightHead = 0
    var res = mutable.ArrayBuffer[Int]()

    while(left.nonEmpty && right.nonEmpty){
      leftHead = left.head
      rightHead = right.head

      if(leftHead <= rightHead){
        res += leftHead
        left = left.tail
      } else {
        res += rightHead
        right = right.tail
      }
    }

    if(left.nonEmpty)
      res ++= left

    if(right.nonEmpty)
      res ++= right

    res.toArray
  }

}
