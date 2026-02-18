package com.seuapp.circuitsim.components

import android.graphics.Canvas
import android.graphics.Paint
import com.seuapp.circuitsim.engine.MatrixSystem
import com.seuapp.circuitsim.model.Node

abstract class Component(
    val node1: Node,
    val node2: Node
) {
    var x: Float = 200f
    var y: Float = 200f

    abstract fun stamp(matrix: MatrixSystem)
    abstract fun draw(canvas: Canvas)

    fun moveTo(newX: Float, newY: Float) {
        x = newX
        y = newY
    }

    fun contains(px: Float, py: Float): Boolean {
        return px in (x - 100)..(x + 100) &&
               py in (y - 50)..(y + 50)
    }
}
