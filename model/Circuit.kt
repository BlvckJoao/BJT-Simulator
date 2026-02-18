package com.seuapp.circuitsim.model

import com.seuapp.circuitsim.components.Component
import com.seuapp.circuitsim.engine.MatrixSystem
import com.seuapp.circuitsim.engine.Solver

class Circuit {

    val nodes = mutableListOf<Node>()
    val components = mutableListOf<Component>()

    fun createNode(): Node {
        val node = Node(nodes.size)
        nodes.add(node)
        return node
    }

    fun addComponent(component: Component) {
        components.add(component)
    }

    fun simulate() {
        val matrix = MatrixSystem(nodes.size)

        components.forEach {
            it.stamp(matrix)
        }

        val result = Solver.solve(matrix)

        result.forEachIndexed { index, voltage ->
            nodes[index].voltage = voltage
        }
    }

    fun findComponentAt(x: Float, y: Float): Int? {
        components.forEachIndexed { index, component ->
            if (component.contains(x, y)) return index
        }
        return null
    }
}
