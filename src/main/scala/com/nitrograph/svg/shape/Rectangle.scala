package com.nitrograph.svg.shape

import org.scalajs.dom
import dom.svg
import dom.document
import com.nitrograph.svg.geometry._
import com.nitrograph.svg.style._

case class Rectangle(
    box: Box,
    style: Style,
    private[Rectangle] val body: svg.Element = {
        document.createElementNS(
            "http://www.w3.org/2000/svg",
            "rect"
        ).asInstanceOf[
            svg.Element
        ]
    }
) extends Shape { rectangle =>
    override def innerBox: Box = {
        rectangle.box
    }

    def attachTo(parent: svg.Element): Rectangle = {
        Rectangle(
            rectangle.box,
            rectangle.style, {
                rectangle.body.setAttribute(
                    "width", s"${rectangle.box.bottomRight.x - rectangle.box.topLeft.x}"
                )
                rectangle.body.setAttribute(
                    "height", s"${rectangle.box.bottomRight.y - rectangle.box.topLeft.y}"
                )
                rectangle.body.setAttribute(
                    "x", s"${rectangle.box.topLeft.x}"
                )
                rectangle.body.setAttribute(
                    "y", s"${rectangle.box.topLeft.y}"
                )
                rectangle.body.setAttribute(
                    "fill", s"${rectangle.style.fillColor}"
                )
                rectangle.body.setAttribute(
                    "stroke", s"${rectangle.style.border.color}"
                )
                rectangle.body.setAttribute(
                    "stroke-width", s"${rectangle.style.border.width}"
                )
                parent.appendChild(rectangle.body)
                rectangle.body
            }
        )
    }
}
