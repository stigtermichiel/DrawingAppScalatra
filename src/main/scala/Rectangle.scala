package org.scalatra

import org.scalatra.Canvas.Canvas

case class Rectangle(canvas: Canvas) extends draw {

  def drawRectangle(leftCx: Int, leftCy: Int, rightCx: Int, rightCy: Int): Canvas = {
    if (leftCx < rightCx && leftCy < rightCy)
      drawLine(rightCx, leftCy, rightCx, rightCy) {
        drawLine(leftCx, leftCy, leftCx, rightCy) {
          drawLine(leftCx, rightCy, rightCx, rightCy) {
            drawLine(leftCx, leftCy, rightCx, leftCy)(canvas)
          }
        }
      }
    else if (leftCx > rightCx) drawRectangle(rightCx, leftCy, leftCx, rightCy)
    else drawRectangle(leftCx, rightCy, rightCx, leftCy)
  }
}
