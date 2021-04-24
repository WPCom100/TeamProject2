package com.example.teamproject2.ui.calandar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalendarViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is calandar Fragment"
    }
    val text: LiveData<String> = _text
}