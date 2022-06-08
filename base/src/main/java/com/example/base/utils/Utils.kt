package com.example.base.utils

import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast
import com.example.base.BaseApplication

object  Utils {
        val displayMetrics = Resources.getSystem().displayMetrics

        fun dp2px(dp : Float): Float{
             return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp, displayMetrics)
        }

        fun toast(str : String){ toast(str,Toast.LENGTH_SHORT)}

        fun toast(str:String,duration:Int){
            Toast.makeText(BaseApplication.currentApplication(),str,duration)
        }
}