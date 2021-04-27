package com.example.teamproject2

/*
Team Project 2
Professor Maxwell - Mobile Dev

    Chase Rowlan
    Landry Strickland
    Justin Mabray
    Clif Charuka

*/
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject2.ui.directory.PersonAdapter

class MainActivity : AppCompatActivity() {

    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var adapter: RecyclerView.Adapter<PersonAdapter.ViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_map, R.id.navigation_directory, R.id.navigation_calander, R.id.navigation_courses))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        Log.d("main", "created main")
    }

    fun LoadCalenderEvents(){

    }
}