package org.scalatra

import org.scalatra.Canvas.Canvas

trait update {

  def update(canvas: Canvas, xCoordinate: Int, yCoordinate: Int, color: Char = 'x') = {
    canvas.updated(yCoordinate - 1, canvas(yCoordinate - 1).updated(xCoordinate - 1, color))
  }

}
