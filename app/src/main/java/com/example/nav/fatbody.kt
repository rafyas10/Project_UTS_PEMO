package com.example.nav

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.log10

class fatbody : AppCompatActivity() {

    private lateinit var weightEditText: EditText
    private lateinit var waistSizeEditText: EditText
    private lateinit var maleRadioButton: RadioButton
    private lateinit var femaleRadioButton: RadioButton
    private lateinit var genderRadioGroup: RadioGroup
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fatbody)

        weightEditText = findViewById(R.id.weightEditText)
        waistSizeEditText = findViewById(R.id.waistSizeEditText)
        maleRadioButton = findViewById(R.id.maleRadioButton)
        femaleRadioButton = findViewById(R.id.femaleRadioButton)
        genderRadioGroup = findViewById(R.id.genderRadioGroup)
        calculateButton = findViewById(R.id.calculateButton)
        resultTextView = findViewById(R.id.resultTextView)

        calculateButton.setOnClickListener {
            calculateBodyFat()
        }
    }

    private fun calculateBodyFat() {
        val weight = weightEditText.text.toString().toDouble()
        val waistSize = waistSizeEditText.text.toString().toDouble()
        val gender = if (maleRadioButton.isChecked) Gender.MALE else Gender.FEMALE

        val bodyFatPercentage = calculateBodyFatPercentage(weight, waistSize, gender)

        resultTextView.text = "Estimated Body Fat Percentage: ${"%.2f".format(bodyFatPercentage)}%"
    }

    private fun calculateBodyFatPercentage(weight: Double, waistSize: Double, gender: Gender): Double {
        // Formula for body fat percentage based on weight, waist size, and gender
        return if (gender == Gender.MALE) {
            86.010 * (log10(waistSize - weight) - log10(weight)) + 70.041 * log10(weight) - 36.76
        } else {
            163.205 * (log10(waistSize + weight) - log10(weight)) - 97.684 * log10(weight) - 78.387
        }
    }

    enum class Gender {
        MALE, FEMALE
    }
}
