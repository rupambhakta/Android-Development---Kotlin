package com.example.playqize

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart : Button  = findViewById(R.id.btnStart)
        val edtName : AppCompatEditText = findViewById(R.id.edtName)
        btnStart.setOnClickListener {
            if (edtName.text?.isEmpty() == true){
                Toast.makeText(this,"Please enter your name.",Toast.LENGTH_LONG).show()
            }
            else{
                val intent = Intent(this, QuizQuestionActivity::class.java)
                intent.putExtra(Constance.USER_NAME,edtName.text.toString())
                startActivity(intent)
                finish()
            }

        }
    }
}