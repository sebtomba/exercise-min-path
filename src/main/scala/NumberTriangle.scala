import scala.util.Try

object NumberTriangle {

  case class Result(sum: Long, path: List[Int])

  def searchMinPath(values: List[List[Int]]): Result =
    searchPath(values, _ < _)

  def searchMaxPath(values: List[List[Int]]): Result =
    searchPath(values, _ > _)

  def searchPath(values: List[List[Int]],
                 compare: (Long, Long) => Boolean): Result = {
    require(values.nonEmpty, "Values can't be empty")

    val rev = values.reverse
    rev.tail
      .foldLeft(rev.head.map(v => Result(v, List(v)))) { (curr, row) =>
        val (_, next) =
          row.foldLeft((curr, List.empty[Result])) { (acc, v) =>
            val (prev, rs) = acc
            val r1 = prev.head
            val r2 = prev.tail.head
            val r = if (compare(r1.sum, r2.sum)) r1 else r2
            (prev.tail, Result(r.sum + v, v :: r.path) :: rs)
          }
        next.reverse
      }
      .head
  }

  def valuesFromString(lines: List[String]): Option[List[List[Int]]] = {
    def numbers(s: String): Option[List[Int]] =
      Try(
        s.split(" ")
          .map(_.trim)
          .filter(_ != "")
          .map(_.toInt)
          .toList
      ).toOption

    lines
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
    if (values.isEmpty) false
    else
      values.zipWithIndex.foldLeft(true)(
        (valid, v) =>
          (valid, v) match {
            case (true, (l, n)) => l.length == n + 1
            case _              => false
        }
      )

}
