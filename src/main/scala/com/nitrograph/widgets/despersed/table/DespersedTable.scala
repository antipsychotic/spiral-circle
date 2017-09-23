package com.nitrograph.widgets.despersed.table

import com.nitrograph.svg.style._
import com.nitrograph.datamediator._
import com.nitrograph.svg.text._
import com.nitrograph.widgets._
import org.scalajs.dom
import dom.svg
import dom.document

case class DesperseTable(
    mediator: DesperseTableMediator[String],
    style: DesperseTable.Style,
    private[DesperseTable] val body: svg.G = {
        document.createElementNS(
            "http://www.w3.org/2000/svg",
            "g"
        ).asInstanceOf[
            svg.G
        ]
    }
) extends Widget { table =>

    def attachTo(parent: svg.Element): DesperseTable = {
        DesperseTable(
            mediator,
            style, {
                parent.appendChild(table.body)
                table.body
            }
        )
    }
}

object DesperseTable {
    case class Style(
        cell: CellStyle,
        row: RowStyle,
        column: ColumnStyle,
        border: BorderStyle,
        text: TextStyle
    )
}
