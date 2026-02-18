package com.seuapp.circuitsim.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import com.seuapp.circuitsim.model.Circuit
import com.seuapp.circuitsim.components.Resistor
import com.seuapp.circuitsim.components.DCSource

class CircuitView(context: Context) : View(context) {

    private val circuit = Circuit()
    private var selectedComponentIndex: Int? = null

    init {
        // Circuito inicial para teste
        val n1 = circuit.createNode()
        val n2 = circuit.createNode()

        circuit.addComponent(DCSource(n1, n2, 10.0))
        circuit.addComponent(Resistor(n1, n2, 1000.0))

        circuit.simulate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        circuit.components.forEach {
            it.draw(canvas)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                selectedComponentIndex = circuit.findComponentAt(event.x, event.y)
            }
            MotionEvent.ACTION_MOVE -> {
                selectedComponentIndex?.let {
                    circuit.components[it].moveTo(event.x, event.y)
                    invalidate()
                }
            }
            MotionEvent.ACTION_UP -> {
                selectedComponentIndex = null
            }
        }
        return true
    }
}
