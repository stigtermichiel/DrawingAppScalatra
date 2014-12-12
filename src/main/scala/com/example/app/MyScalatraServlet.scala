package com.example.app

import org.scalatra._
import org.scalatra.scalate.ScalateSupport

class MyScalatraServlet extends ScalatratestStack with ScalateSupport {

  get("/") {
    contentType="text/html"
    jade("/hello-scalate")
  }

  post("/draw") {
    contentType="text/html"
    val canvas = Canvas.create(params("horizontal").toInt, params("vertical").toInt)
    val displayCanvas = new Display(canvas)
    request.getSession().setAttribute("canvas", canvas)
    jade("/drawing", "canvas" -> displayCanvas.display)
  }

  post("/line") {
    contentType="text/html"
    val canvas = request.getSession().getAttribute("canvas").asInstanceOf[Canvas.Canvas]
    val line = new Line(canvas)
    val canvasWithLine = line.drawsLine(params("x1-coordinate").toInt, params("y1-coordinate").toInt, params("x2-coordinate").toInt, params("y2-coordinate").toInt)
    request.getSession().setAttribute("canvas", canvasWithLine)
    val displayCanvas = new Display(canvasWithLine)
    jade("/drawing", "canvas" -> displayCanvas.display)
  }

  post("/rectangle") {
    contentType="text/html"
    val canvas = request.getSession().getAttribute("canvas").asInstanceOf[Canvas.Canvas]
    val rectangle = new Rectangle(canvas)
    val canvasWithRectangle = rectangle.drawRectangle(params("x1-coordinate").toInt, params("y1-coordinate").toInt, params("x2-coordinate").toInt, params("y2-coordinate").toInt)
    request.getSession().setAttribute("canvas", canvasWithRectangle)
    val displayCanvas = new Display(canvasWithRectangle)
    jade("/drawing", "canvas" -> displayCanvas.display)
  }

  post("/bucketfill") {
    contentType="text/html"
    val canvas = request.getSession().getAttribute("canvas").asInstanceOf[Canvas.Canvas]
    val bucketfill = new BucketFill(canvas)
    val canvasWithBucketfill = bucketfill.bucketFill(params("x1-coordinate").toInt, params("y1-coordinate").toInt, params("x2-coordinate").toCharArray.head)
    request.getSession().setAttribute("canvas", canvasWithBucketfill)
    val displayCanvas = new Display(canvasWithBucketfill)
    jade("/drawing", "canvas" -> displayCanvas.display)
  }




  
}
