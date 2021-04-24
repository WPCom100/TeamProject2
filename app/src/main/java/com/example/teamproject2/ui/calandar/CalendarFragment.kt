package com.example.teamproject2.ui.calandar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject2.R


class CalendarFragment : Fragment() {

    private lateinit var notificationsViewModel: CalendarViewModel
    lateinit var layoutManager : RecyclerView.LayoutManager
    lateinit var adapter: RecyclerView.Adapter<CalandarRecyclerAdapter.ViewHolder>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        //layoutManager = LinearLayoutManager(this)
        //var recyclerView = findViewById<RecyclerView>(R.id.calandar_recycle_view)


        notificationsViewModel =
                ViewModelProvider(this).get(CalendarViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_calandar, container, false)
        val textView: TextView = root.findViewById(R.id.text_calandar)
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}