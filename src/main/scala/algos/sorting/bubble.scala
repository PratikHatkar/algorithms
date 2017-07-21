package algos.sorting

object bubble {

  def sort(arr: Array[Int]): Array[Int] = {
    var swap = false

      for (i <- 0 until arr.length - 1) {

        if (arr(i) > arr(i + 1)) {
          val t = arr(i)
          arr(i) = arr(i + 1)
          arr(i + 1) = t
          swap = true
        }
      }

    if(swap) sort(arr) else arr
  }

}
