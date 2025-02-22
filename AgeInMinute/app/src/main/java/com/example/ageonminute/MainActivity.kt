package com.example.ageonminute

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private var txtSelectedDate : TextView? = null
    private var txtAgeInMinute : TextView? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDatePicker : Button = findViewById(R.id.btnDatePicker)
        txtSelectedDate = findViewById(R.id.txtSelectedDate)
        txtAgeInMinute = findViewById(R.id.txtAgeInMinute)

        btnDatePicker.setOnClickListener {
            clickDatePicker()
            
        }
    }

    private fun clickDatePicker(){
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this,{ _, selectedYear, selectedMonth, selectedDayOfMonth ->

            val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
            // Selected date it set to the TextView to make it visible to user.
            txtSelectedDate?.text   = selectedDate


            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

            val theDate = sdf.parse(selectedDate)
            //use the safe call operator with .let to avoid app crashing it theDate is null
            theDate?.let {

                val selectedDateInMinutes = theDate.time/60000
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                currentDate?.let {
                    // Current date in to minutes.
                    val currentDateToMinutes = currentDate.time/60000
                    val differenceInMinutes = currentDateToMinutes - selectedDateInMinutes
                    txtAgeInMinute?.text = differenceInMinutes.toString()
                }
            }
        },
            year,month,day)
        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()

    }

}