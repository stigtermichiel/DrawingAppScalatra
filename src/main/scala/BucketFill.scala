package org.scalatra

import org.scalatra.Canvas.Canvas

case class BucketFill(canvas: Canvas) extends update {

  def bucketFill(xC: Int, yC: Int, color: Char): Canvas = {
    val toDo = neighbours(xC, yC, color, canvas)
    val firstCanvas: Canvas = update(canvas, xC, yC, color)
    def bucketHelper(toDoHel: Vector[(Int, Int)], done: Vector[(Int, Int)], result: Canvas): Canvas = (toDoHel, done) match {
      case (Vector(), _) => result
      case (head +: _, _) =>
        bucketHelper(doneFilter(toDoHel, color, head._1, head._2, done, result), head +: done, update(result, head._1, head._2, color))
    }
    bucketHelper(toDo, Vector((xC, yC)), firstCanvas)
  }

  def doneFilter(toDo: Vector[(Int, Int)], color: Char, x: Int, y: Int, done: Vector[(Int, Int)], canvas: Canvas) = (neighbours(x, y, color, canvas) ++: toDo).filter { x => !done.contains(x)}

  def neighbours(x: Int, y: Int, color: Char, canvas: Canvas): Vector[(Int, Int)] = {
    val possibleNeighbours = Vector((x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1))
    val inRangeNeighbours = possibleNeighbours.filter(points => points._1 > 0 && points._2 > 0 && points._2 <= canvas.length && points._1 <= canvas(0).length)
    inRangeNeighbours.filter { x => colorCheck(canvas, x._1, x._2, color)}
  }

  def colorCheck(canvas: Canvas, x: Int, y: Int, color: Char): Boolean = (canvas(y - 1)(x - 1) != color) && (canvas(y - 1)(x - 1) != 'x')
}