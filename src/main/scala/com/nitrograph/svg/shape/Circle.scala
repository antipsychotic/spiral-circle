package com.nitrograph.svg.shape

import org.scalajs.dom
import dom.svg
import dom.document
import com.nitrograph.svg.geometry._
import com.nitrograph.svg.style._

case class Circle(
    label: String,
    position: Point,
    radius: Double,
    style: Style,
    private[Circle] val body: svg.Circle = {
        document.createElementNS(
            "http://www.w3.org/2000/svg",
            "circle"
        ).asInstanceOf[
            svg.Circle
        ]
    }
) extends Shape { circle =>
    override def innerBox: Box = {
        import math._

        Box(
            topLeft = Point(
                circle.position.x - circle.radius * cos(Math.PI / 4),
                circle.position.y - circle.radius * sin(Math.PI / 4)
            ),
            bottomRight = Point(
                circle.position.x + circle.radius * cos(Math.PI / 4),
                circle.position.y + circle.radius * sin(Math.PI / 4)
            )
        )
    }

    def attachTo(parent: svg.Element): Circle = {
        Circle(
            circle.label,
            circle.position,
            circle.radius,
            circle.style, {
                circle.body.setAttribute(
                    "r", s"${circle.radius}"
                )
                circle.body.setAttribute(
                    "cx", s"${circle.position.x}"
                )
                circle.body.setAttribute(
                    "cy", s"${circle.position.y}"
                )
                circle.body.setAttribute(
                    "fill", s"${circle.style.fillColor}"
                )
                circle.body.setAttribute(
                    "stroke", s"${circle.style.border.color}"
                )
                circle.body.setAttribute(
                    "stroke-width", s"${circle.style.border.width}"
                )
                parent.appendChild(circle.body)
                circle.body
            }
        )
    }
}
