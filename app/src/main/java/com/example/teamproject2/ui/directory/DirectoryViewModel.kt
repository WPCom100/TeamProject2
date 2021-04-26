package com.example.teamproject2.ui.directory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DirectoryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is directory Fragment"
    }
    val text: LiveData<String> = _text
}