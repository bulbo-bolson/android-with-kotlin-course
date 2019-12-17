package com.curso.notas

import org.json.JSONException
import org.json.JSONObject

class Nota {
    var titulo: String? = null
    var descripcion: String? = null
    var idea: Boolean = false
    var tarea: Boolean = false
    var importante: Boolean = false


    private val JSON_TITULO = "titulo"
    private val JSON_DESCRIPCION = "descripcion"
    private val JSON_IDEA = "idea"
    private val JSON_TAREA = "tarea"
    private val JSON_IMPORTANTE = "importante"

    // Constructores

    constructor() {

    }

    @Throws(JSONException::class)
    constructor(jo: JSONObject) {

        titulo = jo.getString(JSON_TITULO)
        descripcion = jo.getString(JSON_DESCRIPCION)
        idea = jo.getBoolean(JSON_IDEA)
        tarea = jo.getBoolean(JSON_TAREA)
        importante = jo.getBoolean(JSON_IMPORTANTE)
    }

    @Throws(JSONException::class)
    fun convertirAJSON(): JSONObject {

        val jo = JSONObject()

        jo.put(JSON_TITULO, titulo)
        jo.put(JSON_DESCRIPCION, descripcion)
        jo.put(JSON_IDEA, idea)
        jo.put(JSON_TAREA, tarea)
        jo.put(JSON_IMPORTANTE, importante)

        return jo
    }


}