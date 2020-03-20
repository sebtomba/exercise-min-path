import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MinPathSpec extends AnyWordSpec with Matchers {
  "MinPath" when {

    "search min path in graph with 1 row" should {
      "return the node as minimal path" in {
        val values = List(List(3))
        MinPath.searchMinPath(values) mustEqual MinPath.Result(3, List(3))
      }
    }

    "search min path in graph with 4 rows" should {
      "return the minimal path" in {
        val values =
          List(List(7), List(6, 3), List(3, 8, 5), List(11, 2, 10, 9))
        MinPath.searchMinPath(values) mustEqual MinPath.Result(
          18,
          List(7, 6, 3, 2)
        )
      }
    }

    "search min path in graph with 500 rows" should {
      "return the minimal path" in {
        val values = (1 to 500).map(n => (1 to n).toList).toList
        val result = MinPath.searchMinPath(values)
        result.sum mustEqual 500
        result.path.length mustEqual 500
      }
    }
  }
}
