package com.example.notes

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class NewNoteDialog: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity!!)
        val inflater = activity!!.layoutInflater
        val dialogView = inflater.inflate(R.layout.new_note_dialog, null)

        builder.setView(dialogView).setMessage("Add a new note")
        val cancelButton = dialogView.findViewById<Button>(R.id.cancelButton)
        cancelButton.setOnClickListener{
            dismiss()
        }

        val titleEdit = dialogView.findViewById(R.id.titleEditField) as EditText
        val descriptionEdit = dialogView.findViewById(R.id.descriptionEditField) as EditText
        val ideaCheckBox = dialogView.findViewById(R.id.ideaCheckBox) as CheckBox
        val taskCheckBox = dialogView.findViewById(R.id.taskCheckBox) as CheckBox
        val importantCheckBox = dialogView.findViewById(R.id.importantCheckBox) as CheckBox
        val cancel = dialogView.findViewById(R.id.cancelButton) as Button
        val okButton = dialogView.findViewById(R.id.okButton) as Button

        okButton.setOnClickListener{
            val newNote = Note()
            newNote.title = titleEdit.text.toString()
            newNote.description = descriptionEdit.text.toString()
            newNote.idea = ideaCheckBox.isChecked
            newNote.task = taskCheckBox.isChecked
            newNote.important = importantCheckBox.isChecked

            // obtener la referencia a MainActivity
            val callingActivity = activity as MainActivity?

            // pasar la nueva nota de vuelta a MainAcitivty
            callingActivity!!.addNote(newNote)

            dismiss()

        }

        return builder.create()
    }
}