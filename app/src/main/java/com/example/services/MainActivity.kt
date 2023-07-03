package com.example.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnFirst=findViewById<Button>(R.id.btnStart)
        val btnSecond=findViewById<Button>(R.id.btnStop)
        val tvFirst=findViewById<TextView>(R.id.tvServiceStopped)
        val btnThird=findViewById<Button>(R.id.btnSendData)
        val etFirst=findViewById<EditText>(R.id.etData)

        btnFirst.setOnClickListener {
            Intent(this,MyService::class.java).also {
                startService(it)
                tvFirst.text = "Service running"
            }
        }
        btnSecond.setOnClickListener {
            Intent(this, MyService::class.java).also {
                stopService(it)
                tvFirst.text = "Service Stopped"
            }
        }
        btnThird.setOnClickListener {
            Intent(this,MyService::class.java).also {
                val dataString = etFirst.text.toString()
                it.putExtra("EXTRA_DATA",dataString)
                startService(it)
            }
        }
    }
}