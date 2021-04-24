package com.example.teamproject2.ui.calandar

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject2.R

class CalandarRecyclerAdapter() : RecyclerView.Adapter<CalandarRecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemMonth: TextView = itemView.findViewById(R.id.CRI_month)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CalandarRecyclerAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.calandar_row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CalandarRecyclerAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}