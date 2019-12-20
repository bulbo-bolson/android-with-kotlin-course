package com.example.demoservices

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIniciar = findViewById(R.id.btn_iniciar) as Button
        val btnParar = findViewById(R.id.btn_finalizar) as Button

        btnIniciar.setOnClickListener {
            Log.i("contador", "click iniciar")
            startService(Intent(this, ContadorService::class.java))
            // startService(Intent(this, MusicaService::class.java))
        }

        btnParar.setOnClickListener {
            Log.i("contador", "click parar")
            stopService(Intent(this, ContadorService::class.java))
            // stopService(Intent(this, MusicaService::class.java))
        }

        // REPRODUCIR MÚSICA
        var player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        player!!.setLooping(true)
        Log.i("musica", "iniciando musica")
        player!!.start()
        // player!!.stop()
    }



}
