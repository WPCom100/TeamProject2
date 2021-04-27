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
        //declare variable for all ui elements that each row item needs
        var itemMonth: TextView = itemView.findViewById(R.id.CRI_month) //month label
        var itemDay: TextView = itemView.findViewById(R.id.CRI_day) // day label
        var itemTitle: TextView = itemView.findViewById(R.id.CRI_title) // title label
        var itemDesc: TextView = itemView.findViewById(R.id.CRI_description) // descripion label
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarRecyclerAdapter.ViewHolder {
        //create the view holder for the rows
        val view = LayoutInflater.from(parent.context).inflate(R.layout.calandar_row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CalendarRecyclerAdapter.ViewHolder, position: Int) {
        //set the variables for all the ui elements
        holder.itemMonth.text = EventsList[position].getMonthString()
                //use getMonthString to get an abbreviated month instead of a number
        holder.itemDay.text = EventsList[position].Day
        holder.itemTitle.text = EventsList[position].Title
        holder.itemDesc.text = EventsList[position].Description
    }

    override fun getItemCount(): Int {
        return EventsList.size //make as many items as events in the given array
    }
}