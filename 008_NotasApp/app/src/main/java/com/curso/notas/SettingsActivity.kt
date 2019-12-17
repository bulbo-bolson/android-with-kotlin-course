package com.curso.notas

import android.content.Context
import android.os.Bundle
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat

class SettingsActivity : AppCompatActivity() {

    private var mostrarLineaDivisoria: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)

        // obtener preferencias
        val prefs = getSharedPreferences("NotaApp", Context.MODE_PRIVATE)
        mostrarLineaDivisoria = prefs.getBoolean("LineaDivisoria", true)

        // poner switch a on u off segun la preferencia
        val switch1 = findViewById(R.id.switch1) as Switch
        switch1.isChecked = mostrarLineaDivisoria

        switch1.setOnCheckedChangeListener {
            buttonView, isChecked -> mostrarLineaDivisoria = isChecked
        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.settings, SettingsFragment())
            .commit()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onPause() {
        super.onPause()

        val prefs = getSharedPreferences("NotaApp", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putBoolean("lineaDivisoria", mostrarLineaDivisoria)
        editor.apply()
    }

    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)
        }
    }
}