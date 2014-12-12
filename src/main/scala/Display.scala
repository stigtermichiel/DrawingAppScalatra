package org.scalatra

import org.scalatra.Canvas.Canvas


class Display(canvas: Canvas) {
  def display: String = {
    top +
    inside +
    top
  }

  def inside = {
    val inside = new StringBuilder()

    canvas.foreach {
      case a =>
        inside.append("|")
        a foreach {b => {
          if (b.toString == " ") inside.append(b.toString + "&nbsp;&nbsp;")
          else inside.append(b.toString + "&nbsp;")
        }}
        inside.append("|&nbsp;" + "<br>")
    }
    inside.toString()
  }

  def top = {
    val top = new StringBuilder()
    (1 to canvas(0).length).foreach {
      case a => {
        top.append("&nbsp;_")
      }
    }
    top.append("<br>")

    top.toString()
  }
}

