package com.example.nav

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.nav.R

class fcalc : Fragment() {
    private lateinit var ageEditText: EditText
    private lateinit var genderRadioGroup: RadioGroup
    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var activityLevelSpinner: Spinner
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fcalc, container, false)

        ageEditText = view.findViewById(R.id.ageEditText)
        genderRadioGroup = view.findViewById(R.id.genderRadioGroup)
        weightEditText = view.findViewById(R.id.weightEditText)
        heightEditText = view.findViewById(R.id.heightEditText)
        activityLevelSpinner = view.findViewById(R.id.activityLevelSpinner)
        calculateButton = view.findViewById(R.id.calculateButton)
        resultTextView = view.findViewById(R.id.resultTextView)

        // Populate the activity level spinner with options
        val activityLevels = resources.getStringArray(R.array.activity_levels)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, activityLevels)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        activityLevelSpinner.adapter = adapter

        calculateButton.setOnClickListener {
            calculateCalories()
        }


        val bmiButton = view.findViewById<Button>(R.id.bmibtn)

        bmiButton.setOnClickListener() {
            val intent = Intent(requireActivity(), bmi::class.java)
            startActivity(intent)
        }

        val fatbodyButton = view.findViewById<Button>(R.id.fatbtn)

        fatbodyButton.setOnClickListener() {
            val intent = Intent(requireActivity(), fatbody::class.java)
            startActivity(intent)
        }

        val idealButton = view.findViewById<Button>(R.id.idealbtn)

        idealButton.setOnClickListener() {
            val intent = Intent(requireActivity(), idealbody::class.java)
            startActivity(intent)
        }

        val proteinButton = view.findViewById<Button>(R.id.proteinbtn)

        proteinButton.setOnClickListener() {
            val intent = Intent(requireActivity(), protein::class.java)
            startActivity(intent)
        }

        val carbButton = view.findViewById<Button>(R.id.carbbtn)

        carbButton.setOnClickListener() {
            val intent = Intent(requireActivity(), carb::class.java)
            startActivity(intent)
        }

        val fatButton = view.findViewById<Button>(R.id.fattybtn)

        fatButton.setOnClickListener() {
            val intent = Intent(requireActivity(), fat::class.java)
            startActivity(intent)
        }

        return view

    }

    private fun calculateCalories() {
        // Retrieve user input
        val age = ageEditText.text.toString().toInt()
        val genderId = genderRadioGroup.checkedRadioButtonId
        val weight = weightEditText.text.toString().toDouble()
        val height = heightEditText.text.toString().toDouble()
        val activityLevel = activityLevelSpinner.selectedItemPosition

        // Calculate BMR based on gender
        val bmr = if (genderId == R.id.maleRadioButton) {
            66.47 + (13.75 * weight) + (5.003 * height) - (6.75 * age)
        } else {
            655.1 + (9.563 * weight) + (1.850 * height) - (4.676 * age)
        }

        // Calculate daily calorie needs
        val calorieNeeds = when (activityLevel) {
            0 -> bmr * 1.2 // Sedentary
            1 -> bmr * 1.375 // Lightly active
            2 -> bmr * 1.55 // Moderately active
            3 -> bmr * 1.725 // Very active
            4 -> bmr * 1.9 // Super active
            else -> bmr
        }

        resultTextView.text = "Estimated Calories: $calorieNeeds"
    }
}
