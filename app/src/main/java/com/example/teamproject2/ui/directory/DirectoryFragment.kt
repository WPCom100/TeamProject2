package com.example.teamproject2.ui.directory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject2.R

class DirectoryFragment : Fragment() {

    var people: ArrayList<Person> = ArrayList()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        loadPeople()

        // ---- Directory Layout and Adapter ----
        // Assign the layout
        val root = inflater.inflate(R.layout.fragment_directory, container, false)
        val layoutManager = LinearLayoutManager(this.context)
        val recyclerView = root.findViewById<RecyclerView>(R.id.view_directory)
        recyclerView.layoutManager = layoutManager

        // Assign the adapter
        val adapter = PersonAdapter(people)
        recyclerView.adapter = adapter

        // --------------------------------------

        return root

    }

    fun loadPeople() {

        for (id in 1..10) {
            people.add(Person(id, "Landry", "Strickland", "President", "lestrickland@my.okcu.edu"))
        }


    }


}