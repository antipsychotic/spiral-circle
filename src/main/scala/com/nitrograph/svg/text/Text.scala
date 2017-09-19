package com.nitrograph.svg.text

import org.scalajs.dom
import dom.svg
import dom.document
import com.nitrograph.svg.geometry._
import com.nitrograph.svg.style._
/*
case class Text(
    content: String,
    style: TextStyle,
    box: Box,
    private[Text] val node: svg.Locatable = {
        document.createElementNS(
            "http://www.w3.org/2000/svg",
            "text"
        ).asInstanceOf[
            svg.Locatable
        ]
    }
) { text =>
    def attachTo(parent: svg.Locatable): Text = {
        Text(
            text.content,
            text.style, {
                val box = text.box
                text.node.setAttribute(
                    "width", s"${box.bottomRight.x - box.topLeft.x}"
                )
                text.node.setAttribute(
                    "height", s"${box.bottomRight.y - box.topLeft.y}"
                )
                text.node.setAttribute(
                    "x", s"${box.topLeft.x}"
                )
                text.node.setAttribute(
                    "y", s"${box.topLeft.y}"
                )
                parent.appendChild(text.node)
                text.node
            }
        )
    }
}

*/