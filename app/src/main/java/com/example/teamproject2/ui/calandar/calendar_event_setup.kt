package com.example.teamproject2.ui.calandar

import android.content.Context
import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.widget.Button
import android.widget.CalendarView
import android.widget.CalendarView.OnDateChangeListener
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.teamproject2.R
import java.io.*
import java.lang.Exception


class calendar_event_setup() : AppCompatActivity() {
    lateinit var titlebox: TextView
    lateinit var descbox: TextView
    lateinit var calendarthing: CalendarView
    var Gmonth: String = "0" //the raw month string from the calendar widget
    var GDay: String = "0"//the raw day string from the calendar widget, the G is for "get"
    //Gmont and Gday are returned as numbers by the widget
    var EventsList: ArrayList<EventData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calandar_event_setup)

        //create bindings for all the ui elements
        var savebutton = findViewById<Button>(R.id.save_event_button) //save button
        titlebox = findViewById<TextView>(R.id.title_textbox) // textbox for event title
        descbox = findViewById<TextView>(R.id.desc_textbox) // textbox for eveent description
        calendarthing = findViewById<CalendarView>(R.id.calendarView) // calendar widget

        calendarthing.setOnDateChangeListener(OnDateChangeListener { view, year, month, dayOfMonth -> Gmonth = month.toString()
            GDay = dayOfMonth.toString()
        }) //set the calender widget to auto update itself when the user taps a different day

        savebutton.setOnClickListener { SaveEvent() } // set button to run the SaveEvent function

    }

    fun SaveEvent(){ // function takes the data for the new event and saves it to the file
        //collect all data
        var titleToSave:String = titlebox.text.toString() //title
        var descToSave:String = descbox.text.toString() // description
        var date = calendarthing.date// date

        //var month = DateFormat.format("MMM", date) as String
        Log.d("event", "event should save ${titleToSave} , ${descToSave} , ${Gmonth} , ${GDay}") //debug message

        var EventToSave = EventData() //create a new EventData object
        //send the title, descripton, and the month/day from the calendar widget to the object
        EventToSave.BuildFromParts(titleToSave, descToSave, Gmonth, GDay)

        val fileName:String = getString(R.string.savefile_Name)

        //now that we have a new eventData object, we need to save it to file.
        //but if we just open it and write, we will lose any existing events saved within.
        //so we need to read first and create an array of old events,
        // then add our new one and save the new array.

        //start by retrieving existing events if they are there.
        var filereader: FileInputStream = openFileInput(fileName)//open the file input stream
        var inputStreamReader: InputStreamReader = InputStreamReader(filereader)//create stream reader
        val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)//create buffered reader
        val stringBuilder: StringBuilder = StringBuilder()//create stringbuilder to accept file data
        var text: String? = null //string to hold each line temporality as it is recorded
        while({text = bufferedReader.readLine(); text}() != null){//loop for each line found in the file
            stringBuilder.append(text)//record the incoming string
            var newevent = EventData()//create an EventData object
            newevent.BuildFromLine(text)//pass the string found in the file to the new EventData object for decoding
            EventsList.add(newevent)//add the new EventData object to the events array
        }

        Log.d("fromfile", stringBuilder.toString()) //debug message
        EventsList.add(EventToSave) // add the new event to the array of existing events
        //for(E in 0 until EventsList.size){
        //  Log.d("eventarray", EventsList[E].AsString())
        //}

        var NewList: String = "" //this string will hold the text to be written to the file
        for(E in 0 until EventsList.size){ //loop for every event to be saved
            NewList += "${EventsList[E].AsString()}\n" //append the event's string version to the string
        }

        Log.d("the array written", "\n${NewList}") //debug message
        val fileWriter: FileOutputStream //create file output stream
        try{
            fileWriter = openFileOutput(fileName, Context.MODE_PRIVATE) //open the file for editing
            fileWriter.write(NewList.toByteArray()) //save the string that contains all the events
            Log.d("writer", "write went through")// debug message

        }catch (e: Exception){
            Log.d("writer", "write failed")// debug message
        }

        finish() //once the user saves their event, close this activity and return to the schedule
    }

}