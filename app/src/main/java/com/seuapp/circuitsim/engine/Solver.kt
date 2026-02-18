package com.seuapp.circuitsim.engine

object Solver {

    fun solve(matrix: MatrixSystem): DoubleArray {
        val n = matrix.I.size
        val G = matrix.G
        val I = matrix.I

        for (k in 0 until n) {
            for (i in k + 1 until n) {
                val factor = G[i][k] / G[k][k]
                for (j in k until n) {
                    G[i][j] -= factor * G[k][j]
                }
                I[i] -= factor * I[k]
            }
        }

        val result = DoubleArray(n)

        for (i in n - 1 downTo 0) {
            var sum = I[i]
            for (j in i + 1 until n) {
                sum -= G[i][j] * result[j]
            }
            result[i] = sum / G[i][i]
        }

        return result
    }
}
