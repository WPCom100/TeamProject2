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

        // Data should be stored another way, just don't know how to do another in Kotlin - Landry
        people.add(Person(0, getString(R.string.firstName_0), getString(R.string.lastName_0), getString(R.string.position_0), getString(R.string.email_0)))
        people.add(Person(1, getString(R.string.firstName_1), getString(R.string.lastName_1), getString(R.string.position_1), getString(R.string.email_1)))
        people.add(Person(2, getString(R.string.firstName_2), getString(R.string.lastName_2), getString(R.string.position_2), getString(R.string.email_2)))
        people.add(Person(3, getString(R.string.firstName_3), getString(R.string.lastName_3), getString(R.string.position_3), getString(R.string.email_3)))
        people.add(Person(4, getString(R.string.firstName_4), getString(R.string.lastName_4), getString(R.string.position_4), getString(R.string.email_4)))
        people.add(Person(5, getString(R.string.firstName_5), getString(R.string.lastName_5), getString(R.string.position_5), getString(R.string.email_5)))
        people.add(Person(6, getString(R.string.firstName_6), getString(R.string.lastName_6), getString(R.string.position_6), getString(R.string.email_6)))
        people.add(Person(7, getString(R.string.firstName_7), getString(R.string.lastName_7), getString(R.string.position_7), getString(R.string.email_7)))
        people.add(Person(8, getString(R.string.firstName_8), getString(R.string.lastName_8), getString(R.string.position_8), getString(R.string.email_8)))
        people.add(Person(9, getString(R.string.firstName_9), getString(R.string.lastName_9), getString(R.string.position_9), getString(R.string.email_9)))

    }


}