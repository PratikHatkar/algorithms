package algos.sorting

object quick {

  def sort(arr: Array[Int]): Array[Int] = {

    if(arr.length <= 1) arr

    else {

      val pivot = arr(arr.length/2)
      val arrBuff = arr.toBuffer
      arrBuff -= pivot
      val (left, right) = arrBuff.partition(_ <= pivot)

      sort(left.toArray) ++ Array(pivot) ++ sort(right.toArray)
    }
  }
}
