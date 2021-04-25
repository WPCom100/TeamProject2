package com.example.teamproject2.ui.calandar

import android.provider.CalendarContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject2.R

class CalendarRecyclerAdapter(var EventsList:ArrayList<EventData>) : RecyclerView.Adapter<CalendarRecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemMonth: TextView = itemView.findViewById(R.id.CRI_month)
        var itemDay: TextView = itemView.findViewById(R.id.CRI_day)
        var itemTitle: TextView = itemView.findViewById(R.id.CRI_title)
        var itemDesc: TextView = itemView.findViewById(R.id.CRI_description)


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CalendarRecyclerAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.calandar_row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CalendarRecyclerAdapter.ViewHolder, position: Int) {
        holder.itemMonth.text = EventsList[position].getMonthString()
        holder.itemDay.text = EventsList[position].Day
        holder.itemTitle.text = EventsList[position].Title
        holder.itemDesc.text = EventsList[position].Description
    }

    override fun getItemCount(): Int {
        return EventsList.size
    }
}