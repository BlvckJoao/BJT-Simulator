package com.seuapp.circuitsim.components

import android.graphics.Canvas
import android.graphics.Paint
import com.seuapp.circuitsim.engine.MatrixSystem
import com.seuapp.circuitsim.model.Node

class Ground(
    node1: Node,
    node2: Node
) : Component(node1, node2) {

    override fun stamp(matrix: MatrixSystem) {
        val g = 1e9
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

        // vertical line
        canvas.drawLine(x, y - 20f, x, y + 10f, paint)
        // three horizontal lines (ground symbol)
        canvas.drawLine(x - 30f, y + 20f, x + 30f, y + 20f, paint)
        canvas.drawLine(x - 20f, y + 32f, x + 20f, y + 32f, paint)
        canvas.drawLine(x - 10f, y + 44f, x + 10f, y + 44f, paint)
    }
}
