package com.seuapp.circuitsim.components

import android.graphics.Canvas
import android.graphics.Paint
import com.seuapp.circuitsim.engine.MatrixSystem
import com.seuapp.circuitsim.model.Node

class Resistor(
    node1: Node,
    node2: Node,
    val resistance: Double
) : Component(node1, node2) {

    override fun stamp(matrix: MatrixSystem) {
        val g = 1.0 / resistance
        val i = node1.id
        val j = node2.id

        matrix.G[i][i] += g
        matrix.G[j][j] += g
        matrix.G[i][j] -= g
        matrix.G[j][i] -= g
    }

    override fun draw(canvas: Canvas) {
        val paint = Paint()
        paint.strokeWidth = 5f
        canvas.drawLine(x - 80, y, x + 80, y, paint)
    }
}
