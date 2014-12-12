package org.scalatra

import org.scalatra.Canvas.Canvas

case class Line(canvas: Canvas) extends update with draw {
  def drawsLine(x1: Int, y1: Int, x2: Int, y2: Int) = drawLine(x1, y1, x2, y2)(canvas)
}





