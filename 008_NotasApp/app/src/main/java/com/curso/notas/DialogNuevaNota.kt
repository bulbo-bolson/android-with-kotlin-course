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

class DialogNuevaNota : DialogFragment() {

    override
    fun onCreateDialog(savedInstanceState: Bundle?): Dialog {


        val builder = AlertDialog.Builder(activity!!)

        val inflater = activity!!.layoutInflater

        val dialogView = inflater.inflate(R.layout.dialog_nueva_nota, null)


        builder.setView(dialogView).setMessage("Añadir una nueva nota")


        //controles

        val editTitulo =
            dialogView.findViewById(R.id.editTitle) as EditText

        val editDescripcion=
            dialogView.findViewById(R.id.editDescription) as EditText

        val checkBoxIdea =
            dialogView.findViewById(R.id.checkBoxIdea) as CheckBox

        val checkBoxTarea =
            dialogView.findViewById(R.id.checkBoxTodo) as CheckBox

        val checkBoxImportante =
            dialogView.findViewById(R.id.checkBoxImportante) as CheckBox

        val btnCancelar =
            dialogView.findViewById(R.id.btnCancelar) as Button

        val btnOK =
            dialogView.findViewById(R.id.btnOk) as Button



        // manejador boton cancelar
        btnCancelar.setOnClickListener {
            dismiss()
        }



        //manejar boton ok

        btnOK.setOnClickListener {
            // Creatar una nueva nota
            val nuevaNota = Nota()

            // completar laspropiedads
            nuevaNota.titulo = editTitulo.text.toString()

            nuevaNota.descripcion = editDescripcion.text.toString()

            nuevaNota.idea = checkBoxIdea.isChecked
            nuevaNota.tarea = checkBoxTarea.isChecked
            nuevaNota.importante = checkBoxImportante.isChecked

            // optener la referencia a  MainActivity
            val callingActivity = activity as MainActivity?

            // Pasar nuevaNota de vuelta a MainActivity
            callingActivity!!.crearNuevaNota(nuevaNota)

            // Quit the dialog
            dismiss()
        }

        val texto = resources.getString(R.string.ver_detalle_nota)
        builder.setView(dialogView).setMessage(texto)

       return builder.create()
    }
}