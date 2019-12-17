package com.curso.notas

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DataBaseManager(context: Context) {

    private val db: SQLiteDatabase
    private val DB_NAME = "notas_db2"
    private val DB_VERSION = 1

    init {
        // crear la BBDD
        val helper = MiDbHelper(context)
        db = helper.writableDatabase
    }

    fun insert(nota: Nota) {
        val query = "INSERT INTO NOTAS (TITULO, DESCRIPCION, IMPORTANTE, TAREA, IDEA" +
                "VALUES (" +
                "'" + nota.titulo + "'" + ", " +
                "'" + nota.descripcion + "'" + ", " +
                booleanToInt(nota.importante) + ", " +
                booleanToInt(nota.tarea) + ", " +
                booleanToInt(nota.idea) + ", " +
                ");"

        Log.i("notas", query)
        db.execSQL(query)

    }

    fun booleanToInt(valor: Boolean): Int {
        if(valor) {
            return 1
        } else {
            return 0
        }
    }

    fun getAllNotas():ArrayList<Nota> {
        val notas = ArrayList<Nota>()
        return notas
    }

    fun getNotaByTitulo(titulo: String): Nota? {
        val nota: Nota? = null
        return nota
    }

    inner class MiDbHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
        override fun onCreate(db: SQLiteDatabase) {

            val tabla = ("create table NOTAS "
                    + "("
                    + "TITULO text not null, "
                    + "DESCRIPCION text not null, "
                    + "IMPORTANTE integer default 0, "
                    + "TAREA integer default 0, "
                    + "IDEA integer default 0 "
                    + " );")
            db.execSQL(tabla)
        }
        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
            db.execSQL(SQL_DELETE_ENTRIES)
            onCreate(db)
        }
        override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            onUpgrade(db, oldVersion, newVersion)
        }
    }


}