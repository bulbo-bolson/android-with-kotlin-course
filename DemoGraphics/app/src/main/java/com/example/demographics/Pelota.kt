package com.example.demographics

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Pelota(var x: Float, var y: Float) {

    private lateinit var paint: Paint

    init {
        paint = Paint()
        paint.color = Color.RED
    }

    public fun dibujar(canvas: Canvas) {
        // dibujar la pelota en la coordenada x, y en blanco
        // paint.color = Color.WHITE

        // cambiar coordenadas
        var incX = 10f
        x += 10
        if (x >= 2000) {
            x = -incX
        }
        x = x + incX
        // volver a pintar en las nuevas coordenadas con el color del paint
        paint.color = Color.argb(255, 25, 255, 255)
        canvas.drawCircle(x, y, 25f, paint)
    }
}