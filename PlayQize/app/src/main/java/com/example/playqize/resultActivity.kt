package com.example.playqize

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class resultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val txtName : TextView = findViewById(R.id.txtPlayerName)
        val txtScore : TextView = findViewById(R.id.txtScore)
        val btnFinish : Button = findViewById(R.id.btnFinishResult)
        //Fetching data from constance
        val userName = intent.getStringExtra(Constance.USER_NAME)
        val score = intent.getIntExtra(Constance.CORRECT_ANSWERS,0)
        val totalQuestion = intent.getIntExtra(Constance.TOTAL_QUESTION,0)
        txtName.text = userName
        txtScore.text = "Your Score is ${score} out of ${totalQuestion}"
        btnFinish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}