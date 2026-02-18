package com.seuapp.circuitsim.components

import android.graphics.Canvas
import android.graphics.Paint
import com.seuapp.circuitsim.engine.MatrixSystem
import com.seuapp.circuitsim.model.Node

class Diode(
    node1: Node,
    node2: Node,
    val forwardResistance: Double = 100.0,
    val reverseResistance: Double = 1e9
) : Component(node1, node2) {

    override fun stamp(matrix: MatrixSystem) {
        // Simple linear approximation: use forwardResistance as a path.
        // This is a very rough approximation (no non-linear solving here).
        val g = 1.0 / forwardResistance
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

        // draw a simple diode: triangle + line
        // triangle
        val leftX = x - 40f
        val rightX = x + 40f
        val topY = y - 30f
        val bottomY = y + 30f

        val pathPaint = paint
        canvas.drawLine(leftX, y, x, topY, pathPaint)
        canvas.drawLine(leftX, y, x, bottomY, pathPaint)
        canvas.drawLine(x, topY, x, bottomY, pathPaint)
        // cathode line
        canvas.drawLine(x + 10f, y - 30f, rightX, y - 30f, pathPaint)
    }
}
