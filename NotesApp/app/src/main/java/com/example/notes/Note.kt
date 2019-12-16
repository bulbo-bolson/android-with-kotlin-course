package com.example.notes

class Note {
    var title: String? = null
    var description: String? = null
    var idea: Boolean = false
    var task: Boolean = false
    var important: Boolean = false

    override fun toString(): String {
        return "Note(title=$title, description=$description, idea=$idea, task=$task, important=$important)"
    }


}