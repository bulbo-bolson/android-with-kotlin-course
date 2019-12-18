package com.curso.notas

import android.content.Context
import android.util.Log

import org.json.JSONArray
import org.json.JSONException

import java.io.IOException
import java.io.OutputStreamWriter
import java.io.Writer
import org.json.JSONTokener

import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.InputStreamReader
import java.util.ArrayList

class JSONSerializer(
        private val filename: String,
        private val context: Context) {

    @Throws(IOException::class, JSONException::class)
    fun save(notes: List<Nota>) {

        // Make an array in JSON format
        val jArray = JSONArray()

        // And load it with the notes
        for (n in notes)
            jArray.put(n.convertirAJSON())

        // Now write it to the private disk space of our app
        var writer: Writer? = null
        try {
            val out = context.openFileOutput(filename,
                    Context.MODE_PRIVATE)

            writer = OutputStreamWriter(out)
            Log.i("JSONSerializer", jArray.toString())
            writer.write(jArray.toString())
        } finally {
            if (writer != null) {

                writer.close()
            }
        }
    }

    @Throws(IOException::class, JSONException::class)
    fun load(): ArrayList<Nota> {
        val noteList = ArrayList<Nota>()
        var reader: BufferedReader? = null

        try {
            val `in` = context.openFileInput(filename)
            reader = BufferedReader(InputStreamReader(`in`))
            val jsonString = StringBuilder()

            for (line in reader.readLine()) {
                jsonString.append(line)
            }

            val jArray = JSONTokener(jsonString.toString()).
                    nextValue() as JSONArray

            for (i in 0 until jArray.length()) {
                noteList.add(Nota(jArray.getJSONObject(i)))
            }
        } catch (e: FileNotFoundException) {
            Log.e("json",e.message)
        } finally {// This will always run
            reader!!.close()
        }

        return noteList
    }


}// End of class