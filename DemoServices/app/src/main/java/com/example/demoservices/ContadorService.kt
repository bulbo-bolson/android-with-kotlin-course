package com.example.demoservices

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class ContadorService : Service() {

    private var contador: Int = 0

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        while(contador < 50) {
            Log.i("contador service", "${contador}")
            contador++
        }
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("contador service", "Detenido")
    }
}
