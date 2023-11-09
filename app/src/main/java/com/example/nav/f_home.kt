package com.example.nav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class f_home: Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dietPlanAdapter: DietPlanAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_f_home, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        dietPlanAdapter = DietPlanAdapter(createSampleDietPlan())
        recyclerView.adapter = dietPlanAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }

    private fun createSampleDietPlan(): List<String> {
        // Create a sample diet plan with meals and snacks
        return listOf(
            "Breakfast: Oatmeal with fruits",
            "Mid-morning Snack: Greek yogurt with almonds",
            "Lunch: Grilled chicken with quinoa and vegetables",
            "Afternoon Snack: Apple slices with peanut butter",
            "Dinner: Salmon with sweet potatoes and asparagus"
        )
    }
}
