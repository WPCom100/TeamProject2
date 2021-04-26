package com.example.teamproject2.ui.directory

data class Person(var id: Int, var firstName: String, var lastName: String, var position: String, var email: String) {

    var avatarImg: String
    var fullName: String

     init {

         this.avatarImg = "avatar_${id}_${lastName}"
         this.fullName = "$firstName $lastName"

     }


}