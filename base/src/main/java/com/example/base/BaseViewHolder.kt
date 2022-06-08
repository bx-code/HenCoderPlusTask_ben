package com.example.base

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView



 abstract class BaseViewHolder : RecyclerView.ViewHolder {

     constructor(itemView: View) : super(itemView)
     @SuppressLint("UseSparseArrays")
     private val viewHashMap  = HashMap<Int?,View>();

     @SuppressWarnings("unchecked")
      fun <T : View> getView(@IdRes id: Int): T{
         var view = viewHashMap.get<Int?, View>(id)
         if(view  == null){
             view = itemView.findViewById(id)
             viewHashMap.put(id,view)
         }
         return view as T
     }

     protected fun setText(id: Int,text: String){
          getView<TextView>(id).setText(text)
     }
}