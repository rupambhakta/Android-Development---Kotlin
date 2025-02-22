package com.example.playqize

data class Question(
    val id:Int,
    val question:String,
    val image:Int,
    val optionOne:String,
    val optionTwo:String,
    val optionThree:String,
    val optionFore:String,
    val correctAnswer: Int
    )
