package com.example.teamproject2.ui.calandar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject2.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.*
import java.lang.Exception


class CalendarFragment : Fragment() {

    private lateinit var notificationsViewModel: CalendarViewModel
    lateinit var layoutManager : RecyclerView.LayoutManager
    lateinit var adapter: RecyclerView.Adapter<CalendarRecyclerAdapter.ViewHolder>
    var EventsList: ArrayList<EventData> = ArrayList()
    lateinit var recyclerView: RecyclerView

    override fun onResume() { //code for loading in the list to the recycler is under onResume so it runs
        //when returning from a child activity
        super.onResume()

        Log.d("onresume", "calendar resumed") //debug message

        loadEvents() // call loadevents to fill the events array from the save file
        adapter = CalendarRecyclerAdapter(EventsList) // pass the events array to the recycler
        recyclerView.adapter = adapter // set the recyclerview's adapter to the newly created one
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        Log.d("onCreateView", "calendar create") //debug message

        notificationsViewModel = ViewModelProvider(this).get(CalendarViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_calandar, container, false)

        //set binding for the add event button.
        val AddButton: FloatingActionButton = root.findViewById(R.id.add_event_Button)
        AddButton.setOnClickListener{
            ShowAddEvent() //the add event button will call ShowAddEvent()
        }

        recyclerView = root.findViewById<RecyclerView>(R.id.calandar_recycle_view)
        recyclerView.setLayoutManager(LinearLayoutManager(root.getContext()));
        //set up the global recyclerView, onResume will do the rest

        return root

    }//end onCreateView

    fun loadEvents(){ //this function should load events from a file and store then in an arraylist
        Log.d("loadevents", "trying to load file")
        EventsList.clear() //start by clearing existing events from the array if present

        val file:String = getString(R.string.savefile_Name) // set a string for the save file target in internal storage

        val CheckFile = requireContext().getFileStreamPath(file) // create a referecne to the file location
        if (CheckFile.exists()) //check if that reference found an existing file
        { //if the save file exists, star the loading process
            val filereader: FileInputStream? = activity?.openFileInput(file) //open the file input stream
            var inputStreamReader: InputStreamReader = InputStreamReader(filereader) //create stream reader
            val bufferedReader: BufferedReader = BufferedReader(inputStreamReader) //create buffered reader
            val stringBuilder: StringBuilder = StringBuilder() //create stringbuilder to accept file data
            var text: String? = null //string to hold each line temporality as it is recorded
            while({text = bufferedReader.readLine(); text}() != null){ //loop for each line found in the file
                stringBuilder.append(text) //record the incoming string
                var newevent = EventData() //create an EventData object
                newevent.BuildFromLine(text) //pass the string found in the file to the new EventData object for decoding
                EventsList.add(newevent) //add the new EventData object to the events array
            }
            Log.d("fromfile", stringBuilder.toString()) //debug message

            val sortedList: List<EventData> = EventsList.sortedBy{ Event:EventData -> Event.GetDayOfYear()}
            //sort Events using the GetDayOfYear function, which will result int them being in chronological order

            EventsList.clear() //clear events list of the unsorted data
            EventsList.addAll(sortedList) //replace the events with the sorted version
        }
        else{ //if the save file did not exist, create an empty one
            Log.d("loadEvents", "storage file is missing, make it") //debud message
            val fileWriter: FileOutputStream //create new file outout
            try{
                fileWriter = requireContext().openFileOutput(file, Context.MODE_PRIVATE)
                         //open the target file, this creates the new file
                fileWriter.write("".toByteArray()) //write an empty string to the file
                Log.d("writer", "write went through")// debug message

            }catch (e: Exception){
                Log.d("writer", "write failed")// debug message
            }
        }
    }//end LoadEvents

    fun ShowAddEvent(){ //this is called when the new event button is tapped
        Log.d("button", "should go to add event page") // debug message
        val activityIntent = Intent(activity, calendar_event_setup::class.java) //create intent
        startActivity(activityIntent) //activate intent to load the event creator activity
    }


}