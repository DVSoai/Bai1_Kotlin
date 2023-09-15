package com.kingwolf.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    val nr = NetworkStateReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val fitter = IntentFilter()
        fitter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
        registerReceiver(nr, fitter)
    }
    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(nr)
    }
}