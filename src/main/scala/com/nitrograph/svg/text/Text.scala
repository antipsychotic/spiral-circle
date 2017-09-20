package com.nitrograph.svg.text

import org.scalajs.dom
import dom.svg
import dom.document
import com.nitrograph.svg.geometry._
import com.nitrograph.svg.style._

case class Text(
    content: String,
    style: TextStyle,
    box: Box,
    private[Text] val node: svg.Element = {
        document.createElementNS(
            "http://www.w3.org/2000/svg",
            "text"
        ).asInstanceOf[
            svg.Element
        ]
    }
) { text =>
    def attachTo(parent: svg.Element): Text = {
        Text(
            text.content,
            text.style, {
                val box = text.box
                val width = box.bottomRight.x - box.topLeft.x
                val fontHeight = (width / text.content.size) * text.style.aspectRatio
                text.node.setAttribute(
                    "style", {
                        List(
                            s"stroke: ${text.style.fontColor}",
                            s"font-size: ${fontHeight}px",
                            s"font-weight: ${text.style.fontWeight}",
                            s"font-family: ${text.style.fontFamily}"
                        ).mkString(";")
                    }
                )
                text.node.setAttribute(
                    "x", s"${box.topLeft.x}"
                )
                text.node.setAttribute(
                    "y", s"${box.topLeft.y + fontHeight}"
                )
                text.node.appendChild(
                    document.createTextNode(text.content)
                )
                parent.appendChild(text.node)
                box
            }
        )
    }
}
