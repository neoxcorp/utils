package com.neoxcorp.samples

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.neoxcorp.utils.keyboard.extensions.keyboardListener
import com.github.neoxcorp.utils.keyboard.extensions.scaleDown
import com.github.neoxcorp.utils.keyboard.extensions.scaleUp
import com.github.neoxcorp.utils.keyboard.util.UIUtil
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private var statusOfKeyboard: TextView? = null
    private var closeKeyboard: Button? = null
    private var scaleUpButton: FloatingActionButton? = null
    private var scaleDownButton: FloatingActionButton? = null
    private var scalableImage: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupButtons()
        setupKeyboard()
        setupScaleButtons()
    }

    private fun setupButtons() {
        closeKeyboard = findViewById(R.id.closeKeyboard)

        closeKeyboard?.setOnClickListener { view ->
            UIUtil.hideKeyboard(this)
        }
    }

    private fun setupKeyboard() {
        statusOfKeyboard = findViewById(R.id.statusOfKeyboard)

        keyboardListener(this) {
            statusOfKeyboard?.setText(
                if (it) {
                    R.string.keyboard_is_open
                } else {
                    R.string.keyboard_is_close
                }
            )
        }
    }

    private fun setupScaleButtons() {
        scaleUpButton = findViewById(R.id.scaleUpButton)
        scaleDownButton = findViewById(R.id.scaleDownButton)
        scalableImage = findViewById(R.id.scalableImage)

        scaleUpButton?.setOnClickListener { scalableImage.scaleUp() }
        scaleDownButton?.setOnClickListener { scalableImage.scaleDown() }
    }
}