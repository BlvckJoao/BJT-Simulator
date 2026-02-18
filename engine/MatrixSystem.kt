package com.seuapp.circuitsim.engine

class MatrixSystem(size: Int) {
    val G = Array(size) { DoubleArray(size) }
    val I = DoubleArray(size)
}
