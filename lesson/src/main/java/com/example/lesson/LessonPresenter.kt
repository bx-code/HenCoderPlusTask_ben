package com.example.lesson

import com.example.base.http.EntityCallback
import com.example.base.http.HttpClient
import com.example.base.utils.Utils
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class LessonPresenter  {
    companion object{
        private const val LESSON_PATH = "lessons"
    }
    private  var activity:LessonActivity
    private lateinit var lessons : ArrayList<Lesson>

    constructor( activity:LessonActivity){
        this.activity = activity
    }
    private val type : Type =object : TypeToken<List<Lesson>>() {}.type

    fun fetchData(){
        HttpClient.get(LESSON_PATH,type,object : EntityCallback<ArrayList<Lesson>>{
            override fun onSuccess(t: ArrayList<Lesson>) {
                this@LessonPresenter.lessons = t
                activity.runOnUiThread { activity.showResult(lessons) }
            }

            override fun onFailure(message: String) {
                activity.runOnUiThread(object : Runnable{
                    override fun run() {
                        Utils.toast(message)
                    }
                })
            }

        })
    }

    fun showPlayback(){
        var playbackLesson : MutableList<Lesson> = ArrayList<Lesson>()
        for (lesson in lessons){
             if(lesson.state == Lesson.State.PLAYBACK){
                 playbackLesson.add(lesson)
             }
        }
        activity.showResult(playbackLesson)
    }
}