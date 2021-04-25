package com.example.teamproject2.ui.calandar

class EventData {
    var Title: String = ""
    var Description: String = ""
    var Month: String = ""
    var Day: String = ""

    public fun BuildFromParts(NewTitle: String, NewDescription: String, NewMonth: String, NewDay: String)
    {
        Title = NewTitle
        Description = NewDescription
        Month = NewMonth
        Day = NewDay
    }

    public fun BuildFromLine(Line: String?)
    {
        val seperate = Line!!.split(",").toTypedArray()
        Title = seperate[0]
        Description = seperate[1]
        Month = seperate[2]
        Day = seperate[3]
    }

    public fun AsString(): String {
        var stringtosend = "${Title},${Description},${Month},${Day}"
        return stringtosend
    }

    fun GetDayOfYear(): Int
    {
        var tempMonth = Month.toInt()*10
        var dayofyear = tempMonth + Day.toInt()
        return dayofyear
    }

    fun getMonthString(): String {
        when(Month.toInt()) {
            0 -> return "Jan"
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