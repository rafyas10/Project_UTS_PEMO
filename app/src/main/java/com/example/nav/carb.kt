package com.example.nav

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class carb: AppCompatActivity() {

    private lateinit var weightEditText: EditText
    private lateinit var activityRadioGroup: RadioGroup
    private lateinit var sedentaryRadioButton: RadioButton
    private lateinit var moderateRadioButton: RadioButton
    private lateinit var activeRadioButton: RadioButton
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carb)

        weightEditText = findViewById(R.id.weightEditText)
        activityRadioGroup = findViewById(R.id.activityRadioGroup)
        sedentaryRadioButton = findViewById(R.id.sedentaryRadioButton)
        moderateRadioButton = findViewById(R.id.moderateRadioButton)
        activeRadioButton = findViewById(R.id.activeRadioButton)
        calculateButton = findViewById(R.id.calculateButton)
        resultTextView = findViewById(R.id.resultTextView)

        calculateButton.setOnClickListener {
            calculateRecommendedCarbs()
        }
    }

    private fun calculateRecommendedCarbs() {
        val weight = weightEditText.text.toString().toDouble()
        val activityLevel = when (activityRadioGroup.checkedRadioButtonId) {
            R.id.sedentaryRadioButton -> ActivityLevel.SEDENTARY
            R.id.moderateRadioButton -> ActivityLevel.MODERATE
            R.id.activeRadioButton -> ActivityLevel.ACTIVE
            else -> ActivityLevel.SEDENTARY // Default to sedentary if no option is selected
        }

        val carbRecommendation = calculateCarbRecommendation(weight, activityLevel)

        resultTextView.text = "Recommended daily carbohydrate intake: ${"%.2f".format(carbRecommendation)} grams"
    }

    private fun calculateCarbRecommendation(weight: Double, activityLevel: ActivityLevel): Double {
        // Carb recommendation formula based on activity level
        return when (activityLevel) {
            ActivityLevel.SEDENTARY -> weight * 3.0
            ActivityLevel.MODERATE -> weight * 4.0
            ActivityLevel.ACTIVE -> weight * 5.0
        }
    }

    enum class ActivityLevel {
        SEDENTARY, MODERATE, ACTIVE
    }
}
