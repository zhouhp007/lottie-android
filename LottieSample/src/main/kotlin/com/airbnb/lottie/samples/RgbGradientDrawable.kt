package com.airbnb.lottie.samples

import android.animation.ArgbEvaluator
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.util.Log
import com.airbnb.lottie.GammaEvaluator

internal class RgbGradientDrawable: Drawable() {

    private val rgbInterpolator = ArgbEvaluator()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply { style = Paint.Style.FILL }
    val startColor = Color.parseColor("#ff0000")
    val endColor = Color.parseColor("#0000ff")
    var useGamma = false


    override fun draw(canvas: Canvas) {
        for (i in 0..canvas.width) {
            val progress = i / canvas.width.toFloat()
            Log.d("Gabe", "p " + progress)
            if (useGamma) {
                paint.color = GammaEvaluator.evaluate(progress, startColor, endColor)
            } else {
                paint.color = rgbInterpolator.evaluate(progress, startColor, endColor) as Int
            }
            canvas.drawRect(i.toFloat(), 0f, i + 1f, canvas.height.toFloat(), paint)
        }
    }

    override fun setAlpha(alpha: Int) {
    }

    override fun getOpacity(): Int = 255

    override fun setColorFilter(colorFilter: ColorFilter?) {
    }

}