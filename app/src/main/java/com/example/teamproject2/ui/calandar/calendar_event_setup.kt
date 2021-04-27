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
    var Gmonth: String = "0"
    var GDay: String = "0"
    var EventsList: ArrayList<EventData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calandar_event_setup)

        var savebutton = findViewById<Button>(R.id.save_event_button)
        titlebox = findViewById<TextView>(R.id.title_textbox)
        descbox = findViewById<TextView>(R.id.desc_textbox)
        calendarthing = findViewById<CalendarView>(R.id.calendarView)

        //var curDate: String
        calendarthing.setOnDateChangeListener(OnDateChangeListener { view, year, month, dayOfMonth -> Gmonth = month.toString()
            GDay = dayOfMonth.toString()
        })

        savebutton.setOnClickListener { SaveEvent() }

    }

    fun SaveEvent(){
        var titleToSave:String = titlebox.text.toString()
        var descToSave:String = descbox.text.toString()
        var date = calendarthing.date

                //val dateFormatter = DateFormat.getDateInstance(DateFormat.MONTH_FIELD)
        var month = DateFormat.format("MMM", date) as String
        Log.d("event", "event should save ${titleToSave} , ${descToSave} , ${Gmonth} , ${GDay}")

        var EventToSave = EventData()
        EventToSave.BuildFromParts(titleToSave, descToSave, Gmonth, GDay)

        val fileName:String = "storage"


        var filereader: FileInputStream = openFileInput(fileName)
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
        EventsList.add(EventToSave)
        Log.d("linesarray", lines.toString())
        for(E in 0 until EventsList.size){
            Log.d("eventarray", EventsList[E].AsString())

        }



        var NewList: String = ""
        for(E in 0 until EventsList.size){
            NewList += "${EventsList[E].AsString()}\n"
        }
        Log.d("the array written", "\n${NewList}")
        val fileWriter: FileOutputStream
        try{
            fileWriter = openFileOutput(fileName, Context.MODE_PRIVATE)
            fileWriter.write(NewList.toByteArray())
            Log.d("win", "write went through")

        }catch (e: Exception){
            Log.d("fail", "write failed")
        }


        //intent.
        finish()
    }

}