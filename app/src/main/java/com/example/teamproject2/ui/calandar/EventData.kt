package com.example.teamproject2.ui.calandar

class EventData { //this class is instanced to hold information about scheduled events/assignments
    var Title: String = ""
    var Description: String = ""
    var Month: String = ""
    var Day: String = ""

    public fun BuildFromParts(NewTitle: String, NewDescription: String, NewMonth: String, NewDay: String)
    {//this function takes individual data items and uses them to build out the event object
        Title = NewTitle
        Description = NewDescription
        Month = NewMonth
        Day = NewDay
    }

    public fun BuildFromLine(Line: String?)
    { // this function receives a single string, which will contain the event's informaiton
        //as a comma-seperated list. the function will split this string and save the information
        val seperate = Line!!.split(",").toTypedArray() //split the incoming string based
                // ..on commas into an array
        //use the seperated array to fill out the event object
        Title = seperate[0]
        Description = seperate[1]
        Month = seperate[2]
        Day = seperate[3]
    }

    public fun AsString(): String { //this function returns event data as a single string to be saved to file
        var stringtosend = "${Title},${Description},${Month},${Day}" //return as comma-seperated list
        return stringtosend //return the string
    }

    fun GetDayOfYear(): Int //this function returns an arbitrary number loosly based on the date's position in the year
    {
        var tempMonth = Month.toInt()*10 // months are worth 10
        var dayofyear = tempMonth + Day.toInt() //add the value of the month to the number of the day
        //for example, February 15 would be 1*10 + 15 = 25
        return dayofyear //return this number for use in a sorting function in another class
    }

    fun getMonthString(): String { //return the month as an abbreviated name for display in the schedule
        when(Month.toInt()) { //use the Month property to determine which string to return
            0 -> return "Jan" //months start at 0
            1 -> return "Feb"
            2 -> return "Mar"
            3 -> return "Apr"
            4 -> return "May"
            5 -> return "Jun"
            6 -> return "Jul"
            7 -> return "Aug"
            8 -> return "Sep"
            9 -> return "Oct"
            10 -> return "Nov"
            11 -> return "Dec"
        }
        return "Not Found"
    }
}