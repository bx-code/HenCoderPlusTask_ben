package com.example.core.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.examlpe.core.R
import com.example.core.BaseApplication

@SuppressLint("StaticFieldLeak")
object CacheUtils {
    private val context = BaseApplication.currentApplication()

    private val SP = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    fun get(str : String): String? { return  SP.getString(str,null) }

    fun save(Key : String,value: String){SP.edit().putString(Key,value).apply()}

}