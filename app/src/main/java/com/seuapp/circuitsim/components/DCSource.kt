package com.seuapp.circuitsim.components

import android.graphics.Canvas
import android.graphics.Paint
import com.seuapp.circuitsim.engine.MatrixSystem
import com.seuapp.circuitsim.model.Node

class DCSource(
    node1: Node,
    node2: Node,
    val voltage: Double
) : Component(node1, node2) {

    override fun stamp(matrix: MatrixSystem) {
        matrix.I[node1.id] += voltage
        matrix.I[node2.id] -= voltage
    }

    override fun draw(canvas: Canvas) {
        val paint = Paint()
        paint.strokeWidth = 5f
        canvas.drawCircle(x, y, 40f, paint)
    }
}
