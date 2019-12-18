package com.curso.notas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    // Temporary code
    private var notaTemporal = Nota()


    private var listaNotas = ArrayList<Nota>()

    private var recyclerView: RecyclerView? = null
    private var adapter: NotaAdapter? = null


    private var mostrarSeparador: Boolean = false
    private var dbManager: DataBaseManager? = null
    private var serializer: JSONSerializer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
           // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
           //     .setAction("Action", null).show()
            val dialog =  DialogNuevaNota()// DialogDetalleNota()//
            animar()
            dialog.show(supportFragmentManager, "")
        }

        // leer datos de la bd
        // this.dbManager = DataBaseManager(this)
        // this.listaNotas = dbManager!!.getAllNotas()
        serializer = JSONSerializer("notas.json", applicationContext)

        try {
            listaNotas = serializer!!.load()
        } catch (e: Exception) {
            listaNotas = ArrayList()
            Log.e("notas", "Error al cargar las notas de notas.json")
            e.printStackTrace()
        }


        //CONFIGURAR ReclyclerView
        recyclerView =
            findViewById<View>(R.id.recyclerView)
                    as RecyclerView
        adapter = NotaAdapter(this, listaNotas)
        val layoutManager = LinearLayoutManager(applicationContext)

        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.itemAnimator = DefaultItemAnimator()
// añade  una linea de división  entre elementos de la lista
           recyclerView!!.addItemDecoration(
                DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
// poner el adapter
        recyclerView!!.adapter = adapter
    }//fin onCreate

    fun crearNuevaNota(n: Nota) {
        Log.i("nota","Nueva nota ${n.titulo}")
        // Temporary code
        notaTemporal = n
            listaNotas.add(n)
            adapter!!.notifyDataSetChanged()

        listaNotas.add(n)

        // insertar en BBDD
        // dbManager!!.insert(n)
        adapter!!.notifyDataSetChanged()

    }

    fun mostrarNota(notaAMostar: Int) {
        val dialog = DialogDetalleNota()
        dialog.enviarNotaAMostar(listaNotas[notaAMostar])
        dialog.show(supportFragmentManager, "")
    }


    private fun grabarNotas() {
        try {
            this.serializer!!.save(listaNotas)
        } catch (e: Exception) {
            Log.e("notas", "error al grabar las notas")
            e.printStackTrace()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)

        }
    }

    fun animar() {
        var animacionZoom: Animation = AnimationUtils.loadAnimation(this, R.anim.flash2)
        animacionZoom.duration = 3000
        Log.i("animacion", "flash ${animacionZoom.repeatMode}")
        fab.startAnimation(animacionZoom)
    }

    override fun onPause() {
        super.onPause()
        grabarNotas()
    }
}
