package com.example.app.entity

class User {

     lateinit var username:String
     lateinit var password:String
     lateinit var code : String

    constructor()

    constructor(username : String,password : String,code: String){
        this.username=username
        this.password = password
        this.code=code
    }

}