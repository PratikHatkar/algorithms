package algos.searching

object binary {

  def search(arr: List[Int], i:Int, low: Int, high: Int): Boolean = {

    if (high < low) return false

    val mid = (low + high)/2

    arr match {
      case (arr: List[Int]) if i == arr(mid) => true
      case (arr: List[Int]) if i < arr(mid) => search(arr, i, low, mid-1)
      case (arr: List[Int]) if i > arr(mid) => search(arr, i, mid+1, high)
    }
  }
}
