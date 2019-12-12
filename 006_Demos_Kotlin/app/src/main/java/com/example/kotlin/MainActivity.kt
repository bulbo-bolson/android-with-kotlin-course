package com.example.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val myBornYear = 1991
        //Log.i("info", "my age is: ${calcAge(myBornYear)}")
    }

    fun calcAgeInActivity(view: View) {
        val bornYearField: EditText = findViewById(R.id.bornYearInput)
        val displayAgeField: TextView = findViewById(R.id.displayAgeValue)

        val bornYearValue: Int = bornYearField.text.toString().toInt()
        val calculatedAge = calcAge(bornYearValue)
        displayAgeField.setText(calculatedAge)
    }

    fun calcAge(bornYear: Int): Int {
        val today = Date()
        val yearToday = today.year + 1900

        val age = yearToday - bornYear
        return age
    }
}
