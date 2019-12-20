package com.example.demofragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class SimpleFragment : Fragment() {

    companion object {
        val KEY_SALUDO = "Hola"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View? {
        val view = inflater.inflate(
            R.layout.simple_fragment,
            container,
            false
        )

        // leer argumentos
        val bundle = arguments
        var texto = "Hola"
        if (bundle != null && bundle.containsKey(KEY_SALUDO)) {
            texto = bundle.getString(KEY_SALUDO, "hola")
        }

        val button = view.findViewById(R.id.button) as Button

        button.setOnClickListener {
            Toast.makeText(activity, "hola desde fragment 1", Toast.LENGTH_SHORT).show()
        }
        return view
    }

}
