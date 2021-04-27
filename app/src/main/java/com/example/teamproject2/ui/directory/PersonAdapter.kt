package com.example.teamproject2.ui.directory

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.teamproject2.R

class PersonAdapter(var people: ArrayList<Person>) : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        // Linking UI
        var imgAvatar: ImageView = itemView.findViewById(R.id.img_profilePic)
        var txtFullName: TextView = itemView.findViewById(R.id.txt_name)
        var txtPosition: TextView = itemView.findViewById(R.id.txt_position)
        var txtEmail: TextView = itemView.findViewById(R.id.txt_email)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        // Inflate the directory row item into the recycler
        val view = LayoutInflater.from(parent.context).inflate(R.layout.directory_row_item, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {

        // Size of the list based on the number of people in it
        return people.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //Assign name, position, and email to layout text views
        holder.txtFullName.text = people[position].fullName
        holder.txtPosition.text = people[position].position
        holder.txtEmail.text = people[position].email

        //Assign image URI to image view
        var imgURI: Uri = Uri.parse("android.resource://com.example.teamproject2/drawable/${people[position].avatarImg}")
        holder.imgAvatar.setImageURI(imgURI)

    }
}