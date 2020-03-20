object Main {
  def main(args: Array[String]): Unit = {
    val in = io.Source.stdin.getLines.toList
    NumberTriangle
      .valuesFromString(in)
      .fold(
        println("Input from standard input contains non-numeric characters")
      ) { values =>
        if (NumberTriangle.validateValues(values)) {
          val result = NumberTriangle.searchMinPath(values)
          val path = result.path.mkString(" + ")
          println(s"Minimal path is: $path = ${result.sum}")
        } else
          println("Provided values don't form a valid triangle of numbers")
      }
  }
}
