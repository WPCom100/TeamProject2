package com.example.teamproject2.ui.calandar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.teamproject2.R

class CalendarFragment : Fragment() {

    private lateinit var notificationsViewModel: CalendarViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
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