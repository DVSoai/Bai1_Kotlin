package com.kingwolf.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.Toast
import androidx.core.content.getSystemService

class NetworkStateReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        //ConnectivityManager: Trả lời các truy vấn về trạng thái kết nối mạng
        //NetworkInfo: Mô tả trạng thái của giao diện mạng thuộc một loại nhất định (hiện là Di động hoặc Wi-Fi).

        val conn = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo? = conn.activeNetworkInfo

            if (networkInfo != null && networkInfo.isConnected) {
                Toast.makeText(context, "Mạng đã được bật", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, "Mạng đã được tắt", Toast.LENGTH_LONG).show()
            }

    }
}