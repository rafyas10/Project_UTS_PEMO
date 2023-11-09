package com.example.nav

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class bmi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)
    }

    fun calculateBMI(view: View) {
        val weightEditText: EditText = findViewById(R.id.weightEditText)
        val heightEditText: EditText = findViewById(R.id.heightEditText)
        val resultTextView: TextView = findViewById(R.id.resultTextView)

        val weight = weightEditText.text.toString().toDouble()
        val height = heightEditText.text.toString().toDouble()

        val bmi = calculateBMI(weight, height)
        val interpretation = interpretBMI(bmi)

        resultTextView.text = "Your BMI: $bmi\nInterpretation: $interpretation"
    }

    private fun calculateBMI(weight: Double, height: Double): Double {
        return weight / (height * height)
    }

    private fun interpretBMI(bmi: Double): String {
        return when {
            bmi < 16.0 -> "Severely underweight"
            bmi >= 16.0 && bmi < 16.9 -> "Underweight"
            bmi >= 17.0 && bmi < 18.4 -> "Mildly underweight"
            bmi >= 18.5 && bmi < 24.9 -> "Normal Weight"
            bmi >= 25.0 && bmi < 29.9 -> "Overweight"
            bmi >= 30.0 && bmi < 34.9 -> "Obesity Class I (Moderate)"
            bmi >= 35.0 && bmi < 39.9 -> "Obesity Class II (Severe)"
            else -> "Obesity Class III (Very severe or morbidly obese)"
        }
    }
}
