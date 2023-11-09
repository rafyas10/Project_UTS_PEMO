package com.example.nav

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class protein : AppCompatActivity() {

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
        setContentView(R.layout.activity_protein)

        weightEditText = findViewById(R.id.weightEditText)
        activityRadioGroup = findViewById(R.id.activityRadioGroup)
        sedentaryRadioButton = findViewById(R.id.sedentaryRadioButton)
        moderateRadioButton = findViewById(R.id.moderateRadioButton)
        activeRadioButton = findViewById(R.id.activeRadioButton)
        calculateButton = findViewById(R.id.calculateButton)
        resultTextView = findViewById(R.id.resultTextView)

        calculateButton.setOnClickListener {
            calculateRecommendedProtein()
        }
    }

    private fun calculateRecommendedProtein() {
        val weight = weightEditText.text.toString().toDouble()
        val activityLevel = when (activityRadioGroup.checkedRadioButtonId) {
            R.id.sedentaryRadioButton -> ActivityLevel.SEDENTARY
            R.id.moderateRadioButton -> ActivityLevel.MODERATE
            R.id.activeRadioButton -> ActivityLevel.ACTIVE
            else -> ActivityLevel.SEDENTARY // Default to sedentary if no option is selected
        }

        val proteinRecommendation = calculateProteinRecommendation(weight, activityLevel)

        resultTextView.text = "Recommended daily protein intake: ${"%.2f".format(proteinRecommendation)} grams"
    }

    private fun calculateProteinRecommendation(weight: Double, activityLevel: ActivityLevel): Double {
        // Protein recommendation formula based on activity level
        return when (activityLevel) {
            ActivityLevel.SEDENTARY -> weight * 1.2
            ActivityLevel.MODERATE -> weight * 1.5
            ActivityLevel.ACTIVE -> weight * 1.8
        }
    }

    enum class ActivityLevel {
        SEDENTARY, MODERATE, ACTIVE
    }
}
