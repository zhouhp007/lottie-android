package com.airbnb.lottie.samples

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class HsvView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()
    private val colors = floatArrayOf(0f, 1f, 1f)

    var callback: ((Int) -> Unit)? = null

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        for (i in 0..canvas.height - 1) {
            colors[0] = i / canvas.height.toFloat() * 360f;
            paint.color = Color.HSVToColor(colors)
            canvas.drawRect(0f, i.toFloat(), canvas.width.toFloat(), i + 1f, paint)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        colors[0] = event.y / height * 360f
        callback!!(Color.HSVToColor(colors))
        return true
    }
}