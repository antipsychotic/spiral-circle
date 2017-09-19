package com.nitrograph.text2flow.spiralcircle.petal

import scala.collection.immutable.List
import com.nitrograph.text2flow.spiralcircle._

case class SpiralCirclePetal(
    center: SpiralCircle,
    children: List[SpiralCirclePetal]
) {
}
