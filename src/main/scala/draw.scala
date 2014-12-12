package org.scalatra

import org.scalatra.Canvas.Canvas

/**
 * Created by michielstigter on 12/12/2014.
 */trait draw extends update {

  def drawLine(x1: Int, y1: Int, x2: Int, y2: Int)(canvas: Canvas): Canvas = {
    def drawLineHelper(xa: Int, ya: Int, xb: Int, yb: Int)(canvas1: Canvas): Canvas = try {
      (xa, ya, xb, yb) match {
        case (x1a, y1a, x2b, y2b) if x2b < x1a && y1a == y2b => canvas1
        case (x1a, y1a, x2b, y2b) if y1a == y2b => drawLineHelper(x1a, y1a, x2b - 1, y2b)(update(canvas1, x2b, y1a))
        case (x1a, y1a, x2b, y2b) if y2b < y1a && x1a == x2b => canvas1
        case (x1a, y1a, x2b, y2b) if x1a == x2b => drawLineHelper(x1a, y1a, x2b, y2b - 1)(update(canvas1, x2b, y2b))
      }
    } catch {
      case e: MatchError => println(e + ", please enter right params")
        canvas
    }
    drawLineHelper(x1, y1, x2, y2)(canvas)
  }
}
