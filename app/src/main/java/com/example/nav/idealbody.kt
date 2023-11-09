package com.example.nav

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class idealbody : AppCompatActivity() {

    private lateinit var heightEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_idealbody)

        heightEditText = findViewById(R.id.heightEditText)
        calculateButton = findViewById(R.id.calculateButton)
        resultTextView = findViewById(R.id.resultTextView)

        calculateButton.setOnClickListener {
            calculateIdealWeight()
        }
    }

    private fun calculateIdealWeight() {
        val height = heightEditText.text.toString().toDouble()
        val idealWeight = calculateBMI(height)

        resultTextView.text = "Your ideal weight is: ${"%.2f".format(idealWeight)} kg"
    }

    private fun calculateBMI(height: Double): Double {
        // BMI formula: BMI = weight (kg) / (height (m) * height (m))
        // For an ideal BMI, we assume a BMI value of 22.5
        return 22.5 * height * height
    }
}