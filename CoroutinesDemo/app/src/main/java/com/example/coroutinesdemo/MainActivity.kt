package com.example.coroutinesdemo


import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    var customProgressDialog : Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnCoroutine : Button = findViewById(R.id.btnCoroutine)

        btnCoroutine.setOnClickListener {
            showProgressDialog()
            lifecycleScope.launch {
                execute("Task executed successfully")
            }

        }

    }

private suspend fun execute(result:String){
    withContext(Dispatchers.IO){
        for(i in 1..100000){
            Log.e("delay: ",""+i)
        }
        runOnUiThread{
            cancleProgressDialog()
            Toast.makeText(this@MainActivity,result,Toast.LENGTH_LONG).show()}

    }
}

    private fun cancleProgressDialog(){
        if (customProgressDialog!=null){
            customProgressDialog?.dismiss()
            customProgressDialog = null
        }
    }

    private fun showProgressDialog(){
        customProgressDialog = Dialog(this@MainActivity)
        customProgressDialog?.setContentView(R.layout.custon_diolog_progress)
        customProgressDialog?.show()
    }
}