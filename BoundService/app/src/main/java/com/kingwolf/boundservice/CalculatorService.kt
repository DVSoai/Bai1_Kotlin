package com.kingwolf.boundservice

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class CalculatorService : Service() {
    private val binder = CalculatorBinder()

    inner class CalculatorBinder : Binder() {
        fun getService(): CalculatorService {
            return this@CalculatorService
        }
    }

    fun addNumbers(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }
}