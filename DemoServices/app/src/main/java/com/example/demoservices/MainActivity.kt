package com.example.demoservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        }

        btnParar.setOnClickListener {
            Log.i("contador", "click parar")
            stopService(Intent(this, ContadorService::class.java))
        }

    }



}
