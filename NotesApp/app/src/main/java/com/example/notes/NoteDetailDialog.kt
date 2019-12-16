package com.example.notes

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class NoteDetailDialog : DialogFragment() {
    private var note: Note? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity!!)
        val inflater = activity!!.layoutInflater
        val dialogView = inflater.inflate(R.layout.note_detail_dialog, null)

        builder.setView(dialogView).setMessage("Note detail")

        val title = dialogView.findViewById(R.id.noteDetailTitle) as TextView
        title.text = note!!.title
        val description = dialogView.findViewById(R.id.noteDetailDescription) as TextView
        description.text = note!!.description
        val idea = dialogView.findViewById(R.id.noteDetailIdea) as TextView
        val task = dialogView.findViewById(R.id.noteDetailTask) as TextView
        val important = dialogView.findViewById(R.id.noteDetailImportant) as TextView
        val okButton = dialogView.findViewById(R.id.noteDetailOk) as Button
        okButton.setOnClickListener{
            dismiss()
        }

        if (!note!!.important) { important.visibility = View.GONE }
        if (!note!!.task) { task.visibility = View.GONE }
        if (!note!!.idea) { idea.visibility = View.GONE }


        return builder.create()

    }

    fun setNote(note: Note) {
        this.note = note
    }
}