package algos.sorting

object algo extends App {

  println(s"bubble sort output - ${ bubble.sort(Array(24, 12, 7, 9, 6)).toList}")

  println(s"insertion sort output - ${insertion.sort(Array(24, 12, 7, 9, 6)).toList}")

  println(s"selection sort output - ${selection.sort(Array(24, 12, 7, 9, 6)).toList}")

  println(s"merge sort output - ${merge.sort(Array(24, 12, 7, 9, 6)).toList}")

  println(s"quick sort output - ${quick.sort(Array(24, 12, 7, 9, 6)).toList}")

}
