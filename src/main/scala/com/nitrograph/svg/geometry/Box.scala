package com.nitrograph.svg.geometry

case class Box(
    topLeft: Point,
    bottomRight: Point
) { box =>

    def *(width: Width): Box = {
        Box(
            box.topLeft,
            Point(
                box.topLeft.x + (box.bottomRight.x - box.topLeft.x) * width.value,
                box.bottomRight.y
            )
        )
    }

    def /(width: Width): Box = {
        box * Width(1.0 / width.value)
    }

    def +(width: Width): Box = {
        Box(
            Point(
                box.topLeft.x + (box.bottomRight.x - box.topLeft.x) * width.value,
                box.bottomRight.y
            ),
            Point(
                box.topLeft.x + (box.bottomRight.x - box.topLeft.x) * width.value,
                box.bottomRight.y
            )
        )
    }

    def *(height: Height): Box = {
        Box(
            box.topLeft,
            Point(
                box.bottomRight.x,
                box.topLeft.y + (box.bottomRight.y - box.topLeft.y) * height.value
            )
        )
    }

    def /(height: Height): Box = {
        box * Height(1.0 / height.value)
    }

    def +(height: Height): Box = {
        Box(
            Point(
                box.topLeft.x,
                box.topLeft.y + (box.bottomRight.y - box.topLeft.y) * height.value
            ),
            Point(
                box.bottomRight.x,
                box.bottomRight.y + (box.bottomRight.y - box.topLeft.y) * height.value
            )
        )
    }
}

case class Width(
    val value: Double
)

case class Height(
    val value: Double
)