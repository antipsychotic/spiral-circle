package com.nitrograph.svg.geometry

case class Bounds(
    val min: Option[Int],
    val max: Option[Int]
) { bounds =>
    def updated(index: Int): Bounds = {
        Bounds({
                if (bounds.min.getOrElse(index) < index) {
                    bounds.min
                } else {
                    Some(index)
                }
            }, {
                if (bounds.max.getOrElse(index) > index) {
                    bounds.max
                } else {
                    Some(index)
                }
            }
        )
    }
}
