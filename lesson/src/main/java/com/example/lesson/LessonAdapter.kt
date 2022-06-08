package com.example.lesson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.base.BaseViewHolder
import com.example.lesson.entity.Lesson

class LessonAdapter : RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {
     private lateinit var list : ArrayList<Lesson>

     fun updateAndNotify(list: ArrayList<Lesson>){
         this.list = list
         notifyDataSetChanged()
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        return LessonViewHolder(parent)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
            holder.onBind(list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class LessonViewHolder : BaseViewHolder {

        constructor(itemView : View): super(itemView)

        companion object{
             fun onCreate(parant : ViewGroup): LessonViewHolder{
                return LessonViewHolder(LayoutInflater.from(parant.context).inflate(R.layout.item_lesson,parant,false))
            }
        }
        fun onBind(lesson : Lesson){
            var date = lesson.date?:"日期待定"
            setText(R.id.tv_date,date)

            setText(R.id.tv_content,lesson.content)

            val state = lesson.state
            if (state!=null){
                setText(R.id.tv_state,state.toString())
                var colorRes = R.color.playback
                when(state){
                    Lesson.State.PLAYBACK -> colorRes = R.color.playback
                    Lesson.State.LIVE -> colorRes = R.color.live
                    Lesson.State.WAIT -> R.color.wait
                }
                val backgroundColor = itemView.context.getColor(colorRes)
                getView<TextView>(R.id.tv_state).setBackgroundColor(backgroundColor)
            }
        }
    }

}