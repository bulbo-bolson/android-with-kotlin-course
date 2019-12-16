package com.example.demosui

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class MyDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(this.activity!!)
        builder.setMessage("Haz una seleccion")
            .setPositiveButton("OK", { dialog, id ->
                Toast.makeText(this.context, "OK", Toast.LENGTH_SHORT).show()
            })
            .setNegativeButton("Cancelar", { dialog, id ->
                Toast.makeText(this.context, "CANCELAR", Toast.LENGTH_SHORT).show()
            })

        return builder.create()
    }
}