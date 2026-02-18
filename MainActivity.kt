package com.seuapp.circuitsim

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.seuapp.circuitsim.ui.CircuitView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val circuitView = CircuitView(this)
        setContentView(circuitView)
    }
}
