package com.example.teamproject2.ui.home

import android.content.pm.ActivityInfo
import android.os.Bundle
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

class MapFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // ---- Directory Layout and Adapter ----
        // Assign the layout
        val root = inflater.inflate(R.layout.fragment_map, container, false)

        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_USER;

        return root
    }
}