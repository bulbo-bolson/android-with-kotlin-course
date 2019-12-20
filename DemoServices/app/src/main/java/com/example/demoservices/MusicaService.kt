package com.example.demoservices

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder
import android.util.Log

class MusicaService : Service() {

    private var player: MediaPlayer? = null

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val uri = Uri.parse("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3")

        player = MediaPlayer.create(this, uri)
        player!!.setLooping(true)
        player!!.start()

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("musica", "destruido servicio")
        player!!.stop()
    }

}
