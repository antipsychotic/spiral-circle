package com.nitrograph.datamediator

import scala.collection.immutable.HashMap
import com.nitrograph.svg.geometry._

case class DesperseTableMediator[T](
    val elements: HashMap[
        Int,
        HashMap[Int, T]
    ] = HashMap.empty,
    protected val rowIndexBounds: Bounds = {
        Bounds(None, None)
    },
    protected val columnIndexBounds: Bounds = {
        Bounds(None, None)
    }
) { table =>

    import DesperseTableMediator._

    def +(insertingCell: Cell[T]): DesperseTableMediator[T] = {
        val row = insertingCell.row
        val column = insertingCell.column
        val element = insertingCell.element

        DesperseTableMediator[T](
            table.elements.updated(
                row,
                table.elements.get(
                    row
                ).getOrElse(
                    HashMap.empty[Int, T]
                ).updated(
                    column,
                    element
                )
            ),
            rowIndexBounds.updated(row),
            columnIndexBounds.updated(column)
        )
    }

    def row(index: Int): Row[T] = {
        table.elements.get(
            index
        ).map(
            rowElements => {
                Row[T](
                    rowElements
                )
            }
        ) match {
            case Some(row) => {
                row
            }
            case None => {
                Row[T](
                    HashMap.empty
                )
            }
        }
    }

    def column(index: Int): Column[T] = {
        Column[T](
            elements.map({
                case (index, row) => {
                    index -> row.get(index)
                }
            }).filter({
                case (rowIndex, columnValueOption) => {
                    columnValueOption.nonEmpty
                }
            }).map({
                case (rowIndex, columnValueVerifiedOption) => {
                    rowIndex -> columnValueVerifiedOption.get
                }
            })
        )
    }
}

object DesperseTableMediator {
    case class Row[T](
        elements: HashMap[Int, T]
    )

    case class Column[T](
        elements: HashMap[Int, T]
    )

    case class Cell[T](
        row: Int,
        column: Int,
        element: T
    )
}
