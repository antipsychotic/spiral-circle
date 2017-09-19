package com.nitrograph.text2flow.spiralcircle

import scala.collection.immutable.TreeMap
import com.nitrograph.text2flow.spiralcircle.petal._
import com.nitrograph.svg.shape._
import com.nitrograph.svg.geometry._
import com.nitrograph.svg.style._

case class SpiralCircle(
    data: String,
    petals: List[SpiralCirclePetal]
) { spiralcircle =>
    def toSvg: Circle = {
        Circle(
            spiralcircle.data,
            Point(1.0, 1.0),
            1.0,
            Style(
                fillColor = Color(255, 255, 0),
                border = BorderStyle(
                    color = Color(255, 255, 255),
                    width = 2
                )
            )
        )
    }
}
