import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MinPathSpec extends AnyWordSpec with Matchers {
  "MinPath" when {
    def toNodes(values: Array[Array[Int]]): Array[Array[MinPath.Node]] =
      values.zipWithIndex.map {
        case (cols, row) =>
          cols.zipWithIndex.map { case (v, col) => MinPath.Node(row, col, v) }
      }

    "search min path in graph with 1 row" should {
      "return the node as minimal path" in {
        val g = toNodes(Array(Array(3)))
        MinPath.searchMinPath(g).value mustEqual MinPath.Result(3, List(3))
      }
    }

    "search min path in graph with 4 rows" should {
      "return the minimal path" in {
        val values =
          Array(Array(7), Array(6, 3), Array(3, 8, 5), Array(11, 2, 10, 9))
        val g = toNodes(values)
        MinPath.searchMinPath(g).value mustEqual MinPath.Result(
          18,
          List(7, 6, 3, 2)
        )
      }
    }
  }
}
