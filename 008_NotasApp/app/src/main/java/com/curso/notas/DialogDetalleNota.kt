package com.curso.notas

import androidx.fragment.app.DialogFragment;
import android.app.Dialog;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog
import android.view.View
import android.view.LayoutInflater
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class DialogDetalleNota : DialogFragment() {

    private var nota: Nota? = null

    override
    fun onCreateDialog(savedInstanceState: Bundle?): Dialog {


        val builder = AlertDialog.Builder(activity!!)

        val inflater = activity!!.layoutInflater

        val dialogView = inflater.inflate(R.layout.dialog_detalle_nota, null)

        //controles

        val btnOK =
            dialogView.findViewById(R.id.btnOk) as Button


        // manejador boton cancelar
        btnOK.setOnClickListener {
            dismiss()
        }

       // builder.setView(dialogView).setMessage("Ver detalle nota")

      //  return builder.create()


        val txtTitulo = dialogView.findViewById(R.id.textViewTitulo) as TextView
        val txtDesc = dialogView.findViewById(R.id.textViewDescripcion) as TextView

        txtTitulo.text = nota!!.titulo
        txtDesc.text = nota!!.descripcion

        val txtImportante = dialogView.findViewById(R.id.textViewImportante) as TextView

        val txtTarea = dialogView.findViewById(R.id.textViewTarea) as TextView

        val txtIdea = dialogView.findViewById(R.id.textViewIdea) as TextView

        if (!nota!!.importante){
            txtImportante.visibility = View.GONE
        }

        if (!nota!!.tarea){
            txtTarea.visibility = View.GONE
        }

        if (!nota!!.idea){
            txtIdea.visibility = View.GONE
        }

        builder.setView(dialogView).setMessage("Ver detalle nota")
       return builder.create()
    }


    fun enviarNotaAMostar(nota:Nota){
        this.nota = nota
    }
}