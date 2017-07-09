package com.airbnb.lottie.samples

import android.graphics.*
import android.graphics.drawable.Drawable

private data class Op(val op: (Path) -> Unit)

internal class PathDrawable: Drawable() {
    private val OPS = arrayOf(
            Op { p -> p.moveTo(12f,21.35f)},
            Op { p -> p.cubicTo(5.4f,15.36f, 2f,12.28f, 2f, 8.5f)},
            Op { p -> p.cubicTo(2f,5.42f, 4.42f,3f, 7.5f,3f)},
            Op { p -> p.cubicTo(9.24f,3f, 10.91f,3.81f, 12f,5.09f)},
            Op { p -> p.cubicTo(13.09f,3.81f, 14.76f,3f, 16.5f,3f)},
            Op { p -> p.cubicTo(19.58f,3f, 22f,5.42f, 22f,8.5f)},
            Op { p -> p.cubicTo(22f, 12.28f, 18.6f,15.36f, 13.45f,20.04f)},
            Op { p -> p.close()}
    )

    private val p = Path()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 12f
        color = Color.RED
    }
    private val matrix = Matrix().apply {
        preScale(15f, 15f)
    }
    var count = 0
        set(value) {
            field++
            invalidateSelf()
        }

    override fun draw(canvas: Canvas) {
        p.reset()
        OPS.forEachIndexed { i, op -> if (i <= count) op.op(p) }
        p.transform(matrix)

        canvas.drawPath(p, paint)
    }

    override fun setAlpha(alpha: Int) {
    }

    override fun getOpacity(): Int = 255

    override fun setColorFilter(colorFilter: ColorFilter?) {
    }
}