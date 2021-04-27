package com.example.teamproject2.ui.courses

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject2.R

class CoursesFragment : Fragment() {
    var courses: ArrayList<CourseData> = ArrayList()


    private lateinit var coursesViewModel: CoursesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        loadCourses()

        coursesViewModel = ViewModelProvider(this).get(CoursesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_courses, container, false)
        val layoutManager = LinearLayoutManager(this.context)

        val recyclerView = root.findViewById<RecyclerView>(R.id.Course_recycleView)
        recyclerView.layoutManager = layoutManager

        val adapter = courseAdapter(courses)
        recyclerView.adapter = adapter





        return root
    }

    fun loadCourses(){
        courses.add(CourseData("Mobile Development", "CSCI 3113", "Tu/Th 4:30pm-5:45pm"))
        courses.add(CourseData("World Literature", "ENGL 2603", "Remote Learning"))
        courses.add(CourseData("Software Engineering", "CSCI 4213", "Mo/We 11:00am-12:15pm"))
        courses.add(CourseData("Linear Algebra", "MATH3003", "Tu/Th 9:30-10:45"))




    }



}