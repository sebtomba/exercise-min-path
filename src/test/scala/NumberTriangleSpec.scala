import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class NumberTriangleSpec extends AnyWordSpec with Matchers {
  "NumberTriangle" when {

    "search min path in graph with 1 row" should {
      "return the node as minimal path" in {
        val values = List(List(3))
        NumberTriangle.searchMinPath(values) mustEqual NumberTriangle.Result(
          3,
          List(3)
        )
      }
    }

    "search min path in graph with 4 rows" should {
      "return the minimal path" in {
        val values =
          List(List(7), List(6, 3), List(3, 8, 5), List(11, 2, 10, 9))
        NumberTriangle.searchMinPath(values) mustEqual NumberTriangle.Result(
          18,
          List(7, 6, 3, 2)
        )
      }
    }

    "search min path in graph with 500 rows" should {
      "return the minimal path" in {
        val values = (1 to 500).map(n => (1 to n).toList).toList
        val result = NumberTriangle.searchMinPath(values)
        result.sum mustEqual 500
        result.path.length mustEqual 500
      }
    }

    "converting a string" should {
      "return the values" in {
        val str =
          """
            |7
            |6 3
            |3 8 5
            |11 2 10 9
            |""".stripMargin

        val result = NumberTriangle.valuesFromString(str.split("\n").toList)
        val expected =
          List(List(7), List(6, 3), List(3, 8, 5), List(11, 2, 10, 9))
        result mustBe Some(expected)
      }
    }

    "validating provided values" should {
      "return true" in {
        val values =
          List(List(7), List(6, 3), List(3, 8, 5), List(11, 2, 10, 9))
        NumberTriangle.validateValues(values) mustBe true
      }
    }

    "validating provided malformed values" should {
      "return false" in {
        val values =
          List(List(7), List(6, 3, 8), List(3, 8, 5), List(11, 2, 10, 9))
        NumberTriangle.validateValues(values) mustBe false
      }
    }
  }
}
