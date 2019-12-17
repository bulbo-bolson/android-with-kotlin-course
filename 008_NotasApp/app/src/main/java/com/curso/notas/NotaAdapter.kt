package com.curso.notas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotaAdapter(
    private val mainActivity: MainActivity,
    private val listaNotas: List<Nota>)
    : RecyclerView.Adapter<NotaAdapter.ListItemHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): ListItemHolder {

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.lista_notas, parent, false)

        return ListItemHolder(itemView)
    }

    override fun getItemCount(): Int {
        if (listaNotas != null) {
            return listaNotas.size
        }
        // error
        return -1
    }

    override fun onBindViewHolder(
        holder: ListItemHolder, position: Int) {

        val nota = listaNotas!![position]
        holder.mTitulo.text = nota.titulo
        // mostar los  15 primeros caracteres
        if(nota.descripcion!!.length > 15) {
            holder.mDescripcion.text =
                nota.descripcion!!.substring(0, 15)
        }else{
            holder.mDescripcion.text = nota.descripcion
        }
        // Estado
        when {
            nota.idea -> holder.mEstado.text =
                mainActivity.resources.getString(R.string.idea_text)

            nota.importante -> holder.mEstado.text =
                mainActivity.resources.getString(R.string.important_text)

            nota.tarea -> holder.mEstado.text =
                mainActivity.resources.getString(R.string.todo_text)
        }


    }

    inner class ListItemHolder(view: View) :
        RecyclerView.ViewHolder(view),
        View.OnClickListener {

        internal var mTitulo =
            view.findViewById<View>(
                R.id.textViewTitulo) as TextView

        internal var mDescripcion =
            view.findViewById<View>(
                R.id.textViewDescripcion) as TextView

        internal var mEstado =
            view.findViewById<View>(
                R.id.textViewTipo) as TextView

        init {

            view.isClickable = true
            view.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            // llama a main para enviar indice del item seleccionado
            // y abrir una DialogDetalleNota
            mainActivity.mostrarNota(adapterPosition)
        }

    }

}