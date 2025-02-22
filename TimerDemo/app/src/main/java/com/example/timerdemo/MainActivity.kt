package com.example.timerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var countDownTimer: CountDownTimer? = null
    private var timeDuration: Long = 60000
    // pauseOffset = timeDuration - timeLeft
    private var pauseOffset:Long = 0
    private val tvTimer:TextView = findViewById(R.id.tvTimer)
    private val btnStart:Button = findViewById(R.id.btnStart)
    private val btnPause:Button = findViewById(R.id.btnPause)
    private val btnReset:Button = findViewById(R.id.btnReset)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvTimer.text = "${(timeDuration/1000).toString()}"

        btnStart.setOnClickListener {
            startTimer(pauseOffset)
        }
        btnPause.setOnClickListener {
            pauseTimer()
        }
        btnReset.setOnClickListener {
            resetTimer()
        }
    }

    private fun resetTimer() {
        if (countDownTimer!=null){
            countDownTimer!!.cancel()
            tvTimer.text = "${(timeDuration/1000).toString()}"
            countDownTimer = null
            pauseOffset = 0
        }
    }

    private fun pauseTimer() {
        if (countDownTimer!=null){
            countDownTimer!!.cancel()
        }
    }

    private fun startTimer(pauseOffset: Long) {
        countDownTimer = object : CountDownTimer(timeDuration - pauseOffset,1000){
            override fun onTick(millisUntilFinished: Long) {
                this@MainActivity.pauseOffset = timeDuration - millisUntilFinished
                tvTimer.text = (millisUntilFinished/1000).toString()
            }

            override fun onFinish() {
                Toast.makeText(this@MainActivity,"Timer is finished.",Toast.LENGTH_LONG).show()
            }
        }.start()
    }
}