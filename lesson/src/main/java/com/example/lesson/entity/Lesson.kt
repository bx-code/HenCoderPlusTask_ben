package com.example.lesson.entity

class Lesson {
    enum class State{
        PLAYBACK {
            override fun toString(): String {
                return  "有回放"
            }

        },
        LIVE {
            override fun toString(): String {
                return "正在直播"
            }
        },
        WAIT{
            override fun toString(): String {
                return "等待中"
            }
        };

        public abstract override fun  toString():String
    }

    lateinit var date : String
    lateinit var content:String
    lateinit var state:State

    constructor(date:String,content: String,state:State){
        this.date=date
        this.content=content
        this.state=state
    }

}