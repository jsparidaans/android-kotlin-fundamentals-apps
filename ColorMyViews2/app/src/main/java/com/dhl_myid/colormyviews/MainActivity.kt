package com.dhl_myid.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var boxThreeText: TextView
    lateinit var boxFourText: TextView
    lateinit var boxFiveText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun makeColored(view: View) {
        when (view.id) {
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)
            R.id.box_three_text -> view.setBackgroundColor(Color.BLUE)
            R.id.box_four_text -> view.setBackgroundColor(Color.MAGENTA)
            R.id.box_five_text -> view.setBackgroundColor(Color.BLUE)
            R.id.button_red -> boxThreeText.setBackgroundResource(R.color.my_red)
            R.id.button_green -> boxFourText.setBackgroundResource(R.color.my_green)
            R.id.button_yellow -> boxFiveText.setBackgroundResource(R.color.my_yellow)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun setListeners() {
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        boxThreeText = findViewById(R.id.box_three_text)
        boxFourText = findViewById(R.id.box_four_text)
        boxFiveText = findViewById(R.id.box_five_text)

        val redButton = findViewById<Button>(R.id.button_red)
        val greenButton = findViewById<Button>(R.id.button_green)
        val yellowButton = findViewById<Button>(R.id.button_yellow)

        val root = findViewById<View>(R.id.root)

        val clickableViews: List<View> = listOf(
            boxOneText,
            boxTwoText,
            boxThreeText,
            boxFourText,
            boxFiveText,
            root,
            redButton,
            greenButton,
            yellowButton
        )

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }
}