package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.app.entity.User
import com.example.app.widget.CodeView
import com.example.base.utils.Utils
import com.example.core.utils.CacheUtils

class MainActivity : AppCompatActivity(), View.OnClickListener{

    private val usernameKey= "username"
    private val passwordKey= "password"

    private lateinit var et_username : EditText
    private lateinit var et_password : EditText
    private lateinit var et_code : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_username = findViewById(R.id.ed_username)
        et_password = findViewById(R.id.ed_password)
        et_code = findViewById(R.id.ed_code)

        et_username.setText(CacheUtils.get(usernameKey))
        et_password.setText(CacheUtils.get(passwordKey))

        val btn_login = findViewById<Button>(R.id.bt_login)
        val img_code = findViewById<CodeView>(R.id.im_code)
    }

    override fun onClick(p0: View) {
         when(p0.id){
             R.id.im_code ->{
                 val codeView= p0 as CodeView
                 codeView.updateCode()
             }
             R.id.bt_login ->{
                 login()
             }
         }
    }

    private fun login(){
        val username = et_username.text.toString()
        val password = et_password.text.toString()
        val code =et_code.text.toString()

        val user = User(username,password,code)
        if(verify(user)){

        }
    }

    private fun verify(user:User): Boolean{
        if(user.username?.length<4){
            Utils.toast("用户名不合法")
            return false
        }
        if(user.password?.length<4){
            Utils.toast("密码不合法")
            return false
        }
        return true
    }
}