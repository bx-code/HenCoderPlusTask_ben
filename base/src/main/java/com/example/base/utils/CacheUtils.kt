package com.example.core.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.example.base.BaseApplication
import com.example.base.R


@SuppressLint("StaticFieldLeak")
object CacheUtils {
    private val context = BaseApplication.currentApplication()

    private val SP = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    fun get(str : String): String? { return  SP.getString(str,null) }

    fun save(Key : String,value: String){SP.edit().putString(Key,value).apply()}

}