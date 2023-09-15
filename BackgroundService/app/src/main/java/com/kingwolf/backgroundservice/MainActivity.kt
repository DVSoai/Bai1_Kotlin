package com.kingwolf.backgroundservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart : Button = findViewById(R.id.btn_start)
        val btnStop: Button = findViewById(R.id.btn_stop)
        btnStart.setOnClickListener{
            val serviceIntent = Intent(this, MusicService::class.java)
           startService(serviceIntent)
        }
        btnStop.setOnClickListener {
            val serviceIntent = Intent(this, MusicService::class.java)
            stopService(serviceIntent)
        }




    }
}