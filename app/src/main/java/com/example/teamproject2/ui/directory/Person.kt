package com.example.teamproject2.ui.directory

data class Person(var id: Int, var firstName: String, var lastName: String, var position: String, var email: String) {

    var avatarImg: String
    var fullName: String

     init {
        // Build the image URI structure based off of ID and last name
         this.avatarImg = "${lastName.toLowerCase()}_${id}"

         // Build a string with the full name for simplification, while leaving them separate for future access
         this.fullName = "$firstName $lastName"

     }


}