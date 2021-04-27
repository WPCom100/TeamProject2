package com.example.teamproject2.ui.courses

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject2.R
import com.example.teamproject2.ui.directory.Person
import com.example.teamproject2.ui.directory.PersonAdapter

class courseAdapter(var courses: ArrayList<CourseData>) : RecyclerView.Adapter<courseAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var nameText: TextView = itemView.findViewById(R.id.CourseName_text)
        var codeText: TextView = itemView.findViewById(R.id.CourseCode_text)
        var timeText: TextView = itemView.findViewById(R.id.CourseTime_text)


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): courseAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.courses_row_item, parent, false)
        return courseAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return courses.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Assign name, position, and email to layout text views
        holder.nameText.text = courses[position].name
        holder.codeText.text = courses[position].code
        holder.timeText.text = courses[position].time
    }
}