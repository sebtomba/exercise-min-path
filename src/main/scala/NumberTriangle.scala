import scala.util.Try
object NumberTriangle {

  case class Result(sum: Long, path: List[Int])

  def searchMinPath(values: List[List[Int]]): Result =
    searchPath(values, _ < _)

  def searchMaxPath(values: List[List[Int]]): Result =
    searchPath(values, _ > _)

  def searchPath(values: List[List[Int]],
                 compare: (Long, Long) => Boolean): Result = {
    require(values.nonEmpty, "The values can't be empty")

    @scala.annotation.tailrec
    def next(current: List[Result],
             values: List[Int],
             acc: List[Result] = Nil): List[Result] =
      if (values.isEmpty) acc.reverse
      else
        current match {
          case r1 :: r2 :: _ =>
            val r = if (compare(r1.sum, r2.sum)) r1 else r2
            next(
              current.tail,
              values.tail,
              Result(r.sum + values.head, values.head :: r.path) :: acc
            )

          case _ => throw new RuntimeException("Unexpected result length")
        }

    val reverted = values.reverse
    val start = reverted.head.map(v => Result(v, List(v)))
    reverted.tail.foldLeft(start)((acc, vs) => next(acc, vs)).head
  }

  def valuesFromString(str: String): Option[List[List[Int]]] = {
    def numbers(s: String): Option[List[Int]] =
      Try(
        s.split(" ")
          .map(_.trim)
          .filter(_ != "")
          .map(_.toInt)
          .toList
      ).toOption

    str
      .split("\n")
      .toList
      .map(_.trim)
      .filter(_ != "")
      .map(numbers)
      .foldLeft(Option(List.empty[List[Int]]))(
        (acc, ns) =>
          (acc, ns) match {
            case (Some(result), Some(numbers)) => Some(numbers :: result)
            case _                             => Option.empty[List[List[Int]]]
        }
      )
      .map(_.reverse)
  }

  def validateValues(values: List[List[Int]]): Boolean =
    values.zipWithIndex.foldLeft(true)(
      (valid, v) =>
        (valid, v) match {
          case (true, (l, n)) => l.length == n + 1
          case _              => false
      }
    )

}
