package com.nitrograph.svg.style

case class Style(
    fillColor: Color,
    border: BorderStyle
)

case class Color(
    red: Int,
    green: Int,
    blue: Int
) {
    override def toString: String = s"rgb($red,$green,$blue)"
}

case class BorderStyle(
    color: Color,
    width: Int
) {
    override def toString: String = s"border: ${width}px solid $color"
}
