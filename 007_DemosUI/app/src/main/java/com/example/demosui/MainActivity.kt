package com.example.demosui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val greetButton: Button = Button(this)
        greetButton.text = "CLICK"
        greetButton.setBackgroundColor(Color.BLUE)
        greetButton.setTextColor(Color.WHITE)

        greetButton.setOnClickListener{
            Log.i("buttons", "You clicked ${greetButton.id}")
            Toast.makeText(this, "Hello !", Toast.LENGTH_SHORT).show()
        }

        linearLayoutButtons.addView(greetButton)

        val confirmButton: Button = Button(this)
        confirmButton.text = "ABRIR DIALOGO"
        confirmButton.setBackgroundColor(Color.BLUE)
        greetButton.setTextColor(Color.WHITE)

        confirmButton.setOnClickListener{
            val myDialog = MyDialog()
            myDialog.show(supportFragmentManager, "confirmacion")
        }

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        params.setMargins(20, 20, 20, 20)

        linearLayoutButtons.addView(confirmButton)


    }


}
