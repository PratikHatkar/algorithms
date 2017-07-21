package algos

object selection {

  def sort(arr: Array[Int]): Array[Int] = {

    for(i <- 0 until arr.length){
      var min = i
      for(j <- i+1 until arr.length)
      if(arr(j) < arr(min))
        min = j

      val t = arr(i)
      arr(i) = arr(min)
      arr(min) = t
    }
    arr
  }
}
