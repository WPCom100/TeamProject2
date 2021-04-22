package com.example.teamproject2.ui.courses

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.teamproject2.R

class CoursesFragment : Fragment() {



    private lateinit var coursesViewModel: CoursesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        coursesViewModel = ViewModelProvider(this).get(CoursesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_courses, container, false)
        val textView: TextView = root.findViewById(R.id.text_courses)
        coursesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        return root
    }



}