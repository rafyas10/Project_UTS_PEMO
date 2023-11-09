package com.example.nav

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DietPlanAdapter(private val dietPlan: List<String>) :
    RecyclerView.Adapter<DietPlanAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dietItemTextView: TextView = view.findViewById(R.id.dietItemTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_diet_plan, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dietItem = dietPlan[position]
        holder.dietItemTextView.text = dietItem
    }

    override fun getItemCount(): Int {
        return dietPlan.size
    }
}
