import cats.Eval
import cats.syntax.all._

object MinPath {

  case class Node(row: Int, column: Int, value: Int)
  case class Result(sum: Int, nodes: List[Int])

  def searchMinPath(graph: Array[Array[Node]]): Eval[Result] = {

    def childNodes(node: Node): Option[(Node, Node)] =
      if (node.row + 1 < graph.length) {
        val nodes = graph(node.row + 1)
        (nodes(node.column), nodes(node.column + 1)).some
      } else None

    def search(node: Node): Eval[Result] =
      childNodes(node)
        .map {
          case (l, r) =>
            for {
              minL <- search(l)
              minR <- search(r)
            } yield {
              val result = if (minL.sum < minR.sum) minL else minR
              Result(result.sum + node.value, node.value :: result.nodes)
            }
        }
        .getOrElse(Eval.now(Result(node.value, List(node.value))))

    search(graph(0)(0))
  }
}
