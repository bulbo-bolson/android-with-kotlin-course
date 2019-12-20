package com.example.demofragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    private lateinit var miFragment: SimpleFragment
    private lateinit var miFragment2: SimpleFragment2
    private var showingFragment: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
        // POR DISEÑO
        setContentView(R.layout.activity_main_fragment)
         */

        // POR CODIGO
        setContentView(R.layout.activity_main)
        miFragment = SimpleFragment()
        miFragment2 = SimpleFragment2()
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frameLayout, miFragment)
        fragmentTransaction.add(R.id.frameLayout, miFragment2)
        fragmentTransaction.commit()

    }

    fun switchFragment(view: View) {
        val fragmentManager: FragmentManager = getSupportFragmentManager()
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        if (showingFragment == 1) {
            fragmentTransaction.replace(R.id.frameLayout, miFragment2)
            fragmentTransaction.addToBackStack(null)
            showingFragment = 2
        } else {

            // PASAR ARGUMENTOS
            val bundle = Bundle()
            bundle.putString(SimpleFragment.KEY_SALUDO, "Fragmento 1 hola !!")
            miFragment.setArguments(bundle)

            fragmentTransaction.replace(R.id.frameLayout, miFragment)
            fragmentTransaction.addToBackStack(null)
            showingFragment = 1
        }
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Log.i("fragment", "atrás")
        if (showingFragment == 1) {
            showingFragment = 2
        } else {
            showingFragment = 1
        }
    }
}
