package algos

object insertion {

  def sort(arr: Array[Int]): Array[Int] = {
    for(i <- 1 until arr.length){
      var j = i
      while(j > 0 && arr(j) < arr(j - 1)){
        val t = arr(j)
        arr(j) = arr(j - 1)
        arr(j - 1) = t
        j -= 1
      }
    }
    arr
  }
}
