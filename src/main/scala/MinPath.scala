object MinPath {

  case class Result(sum: Int, path: List[Int])

  def searchMinPath(values: List[List[Int]]): Result = {
    require(values.nonEmpty, "The values can't be empty")

    @scala.annotation.tailrec
    def next(current: List[Result],
             values: List[Int],
             acc: List[Result] = Nil): List[Result] =
      if (values.isEmpty) acc.reverse
      else
        current match {
          case r1 :: r2 :: _ =>
            val r = if (r1.sum < r2.sum) r1 else r2
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

}
