package com.example.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.util.*
import com.example.kotlin.model.Employee

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val myBornYear = 1991
        //Log.i("info", "my age is: ${calcAge(myBornYear)}")

        // aqui se crean como valores por defecto todo son 0s
        var total = IntArray(10)

        // aqui se crean valores 0, 1, 2, 3
        // entonces en la lambda van 0 * 3 + 1 * 3, 2 * 3, 3 * 4
        val valores = IntArray(10) {
            it * 3
        }

        var e: Employee = Employee()
        e.salary = 50

        valores.forEach {
            Log.i("pruebas", "array es ${valores[it]}")
        }


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
