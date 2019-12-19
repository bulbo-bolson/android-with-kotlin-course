package com.example.demographics

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.Log
import android.view.MotionEvent
import android.view.SurfaceView

class LiveDrawingView (context: Context) : SurfaceView(context), Runnable {

    private lateinit var canvas: Canvas
    private var xIni: Float = 100f
    private var yIni: Float = 50f

    fun moverPelota() {
        val pelota = Pelota(100f, 20f)
        var i = 0
        while (i++ <200) {
            dibujar(pelota)
        }
    }

    override fun run() {
        moverPelota()
    }

    private lateinit var thread: Thread
    fun resume() {
        thread = Thread(this)
        thread.start()
    }

    private fun dibujar(pelota: Pelota) {
        Thread.sleep(200)
        if (holder.surface.isValid) {
            // Lock the canas (graphics memory) ready to draw
            canvas = holder.lockCanvas()

            // Fill the screen with a solid color
            canvas.drawColor(Color.argb(255, 0, 0, 0))

            // Draw the particle systems
            pelota.dibujar(canvas)

            // Display the drawing on screen
            // unlockCanvasAndPost is a function of SurfaceHolder
            holder.unlockCanvasAndPost(canvas)
        }
    }

    fun pause() {
        try {
            thread.join()
        } catch (e: InterruptedException) {
            Log.i("Error", "joining thread")
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.i("touch", "action ${event!!.action}")
        Log.i("touch", "action ${event!!.x}")
        Log.i("touch", "action ${event!!.y}")
        this.xIni = event.x
        this.yIni = event.y
        var hilo : Thread = Thread(this)
        hilo.start()

        return true
    }

}