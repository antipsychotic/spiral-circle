package com.nitrograph.svg.shape

import org.scalajs.dom
import dom.svg
import dom.document
import com.nitrograph.svg.geometry._
import com.nitrograph.svg.style._
/*
case class Polygon(
    curve: Curve,
    style: Style,
    private[Polygon] val body: svg.Element = {
        document.createElementNS(
            "http://www.w3.org/2000/svg",
            "polygon"
        ).asInstanceOf[
            svg.Element
        ]
    }
) extends Shape { polygon =>
    def attachTo(parent: svg.Element): Rectangle = {
        Rectangle(
            polygon.curve,
            polygon.style, {
                polygon.setAttribute(
                    "points", {
                        polygon.curve.map( point =>
                            s"${point.x} ${point.y}"
                        ).mkString(" ")
                    }
                )
                polygon.body.setAttribute(
                    "stroke", s"${polygon.style.border.color}"
                )
                polygon.body.setAttribute(
                    "stroke-width", s"${polygon.style.border.width}"
                )
                parent.appendChild(polygon.body)
                polygon.body
            }
        )
    }
}
*/