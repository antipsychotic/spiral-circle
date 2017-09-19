package com.nitrograph.svg.shape

import org.scalajs.dom
import dom.svg
import com.nitrograph.svg.geometry._

trait Shape {
    def innerBox: Box
}
