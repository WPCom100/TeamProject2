package com.example.teamproject2.ui.calandar

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject2.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader


class CalendarFragment : Fragment() {

    private lateinit var notificationsViewModel: CalendarViewModel
    lateinit var layoutManager : RecyclerView.LayoutManager
    lateinit var adapter: RecyclerView.Adapter<CalendarRecyclerAdapter.ViewHolder>
    var EventsList: ArrayList<EventData> = ArrayList()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        //layoutManager = LinearLayoutManager(this)

        loadEvents()



        notificationsViewModel =
                ViewModelProvider(this).get(CalendarViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_calandar, container, false)
        val textView: TextView = root.findViewById(R.id.text_calandar)
        val AddButton: FloatingActionButton = root.findViewById(R.id.add_event_Button)
        AddButton.setOnClickListener{
            ShowAddEvent()
        }



        var recyclerView = root.findViewById<RecyclerView>(R.id.calandar_recycle_view)
        recyclerView.setLayoutManager(LinearLayoutManager(root.getContext()));

        adapter = CalendarRecyclerAdapter(EventsList)
        recyclerView.adapter = adapter

        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        return root

    }

    fun loadEvents(){ //this function should load events from a file and store then in an arraylist



        Log.d("loadevents", "trying to load file")

        val file:String = "storage"



        //var filereader: FileInputStream = activity.openFileInput(file)
        val filereader: FileInputStream? = activity?.openFileInput(file)
        var inputStreamReader: InputStreamReader = InputStreamReader(filereader)
        val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
        val stringBuilder: StringBuilder = StringBuilder()
        var lines:ArrayList<String?> = ArrayList()
        var text: String? = null
        while({text = bufferedReader.readLine(); text}() != null){
            stringBuilder.append(text)
            lines.add(text)
            var newevent = EventData()
            newevent.BuildFromLine(text)
            EventsList.add(newevent)
        }
        Log.d("fromfile", stringBuilder.toString())

        val sortedList: List<EventData> = EventsList.sortedBy{ Event:EventData -> Event.GetDayOfYear()}

        EventsList.clear()
        EventsList.addAll(sortedList)

    }

    fun ShowAddEvent(){
        Log.d("button", "should go to add event page")
        val activityIntent = Intent(activity, calendar_event_setup::class.java)
        startActivity(activityIntent)
    }


}