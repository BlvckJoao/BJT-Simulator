package com.seuapp.circuitsim.components

import android.graphics.Canvas
import android.graphics.Paint
import com.seuapp.circuitsim.engine.MatrixSystem
import com.seuapp.circuitsim.model.Node

class Capacitor(
    node1: Node,
    node2: Node,
    val capacitance: Double
) : Component(node1, node2) {

    override fun stamp(matrix: MatrixSystem) {
        // In this simple DC solver a capacitor is an open circuit (no DC current),
        // so we don't modify the conductance matrix here.
    }

    override fun draw(canvas: Canvas) {
        val paint = Paint()
        paint.strokeWidth = 5f
        // two parallel plates
        canvas.drawLine(x - 40f, y - 20f, x - 10f, y - 20f, paint)
        canvas.drawLine(x - 40f, y + 20f, x - 10f, y + 20f, paint)
        canvas.drawLine(x + 10f, y - 20f, x + 40f, y - 20f, paint)
        canvas.drawLine(x + 10f, y + 20f, x + 40f, y + 20f, paint)
    }
}
