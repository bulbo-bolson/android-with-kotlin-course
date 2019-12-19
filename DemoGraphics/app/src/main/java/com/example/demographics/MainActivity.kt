package com.example.demographics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    lateinit var miImageView: ImageView
    lateinit var miBlankBitmap: Bitmap
    lateinit var miCanvas: Canvas
    lateinit var miPaint: Paint

    private lateinit var liveDrawingView: LiveDrawingView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        liveDrawingView = LiveDrawingView(this)
        setContentView(liveDrawingView)

        /*
        val altoEnPixels = 800
        val anchoEnPixels = 600
        miBlankBitmap = Bitmap.createBitmap(anchoEnPixels, altoEnPixels, Bitmap.Config.ARGB_8888)
        miCanvas = Canvas(miBlankBitmap)
        miImageView = ImageView(this)

        miPaint = Paint()
        miPaint.textSize = 100f
        miPaint.color = Color.argb(1, 25, 255, 255)

        miCanvas.drawText("Hola", 100f, 100f, miPaint)
        miCanvas.drawColor(Color.argb(255, 0, 0, 255))
        miImageView.setImageBitmap(miBlankBitmap)

        val pelota = Pelota(20f, 40f, miCanvas)
        pelota.dibujar()
        pelota.dibujar()
        pelota.dibujar()
        pelota.dibujar()

        setContentView(miImageView)
         */
    }

    override fun onResume() {
        super.onResume()
        liveDrawingView.resume()
    }
}
