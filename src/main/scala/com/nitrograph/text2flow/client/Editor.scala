package com.nitrograph.text2flow.client

import org.scalajs.dom
import dom.document
import dom.svg
import scala.scalajs.js.annotation.JSExportTopLevel
import com.nitrograph.svg.shape._
import com.nitrograph.svg.text._
import com.nitrograph.svg.geometry._
import com.nitrograph.svg.style._

object Editor {
    def main(arguments: Array[String]): Unit = {
        val svgCanvas = document.getElementById(
            "svg"
        ).asInstanceOf[
            svg.Element
        ]

        val circle = Circle(
            "SpiralCircle",
            Point(150.0, 150.0),
            150.0,
            Style(
                fillColor = Color(255, 255, 0),
                border = BorderStyle(
                    color = Color(255, 0, 0),
                    width = 2
                )
            )
        ).attachTo(
            svgCanvas
        )

        Rectangle(
            circle.innerBox / Height(4.0),
            Style(
                fillColor = Color(255, 0, 255),
                border = BorderStyle(
                    color = Color(0, 0, 255),
                    width = 4
                )
            )
        ).attachTo(
            svgCanvas
        )

        Text(
            "text",
            TextStyle(
                fontColor = Color(128, 128, 0),
                fontWeight = 300,
                aspectRatio = 0.5,
                fontFamily = "Monaco"
            ),
            circle.innerBox / Height(4.0)
        ).attachTo(
            svgCanvas
        )

        Rectangle(
            circle.innerBox / Height(4.0) + Height(1.0),
            Style(
                fillColor = Color(255, 0, 255),
                border = BorderStyle(
                    color = Color(0, 0, 255),
                    width = 4
                )
            )
        ).attachTo(
            svgCanvas
        )
    }
}
