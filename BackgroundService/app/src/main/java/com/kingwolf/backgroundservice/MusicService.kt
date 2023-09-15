package com.kingwolf.backgroundservice

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

class MusicService : Service() {
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.music)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer.start()

        // Ghi lại sự kiện
        logEvent("Music started")

        // Trả về giá trị này để dịch vụ không bị hủy bỏ ngay khi hoàn thành onStartCommand()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        mediaPlayer.release()

        // Ghi lại sự kiện
        logEvent("Music stopped")
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun logEvent(event: String) {
        // Ghi lại sự kiện vào hệ thống log
        Log.d("MusicService", event)
    }
}