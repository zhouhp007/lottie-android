package com.airbnb.lottie.samples

import android.graphics.*
import android.graphics.drawable.Drawable

private data class Op(val op: (Path) -> Unit)

internal class PathDrawable: Drawable() {
    private val HEART_OPS = arrayOf(
            Op { p -> p.moveTo(12f,21.35f)},
            Op { p -> p.cubicTo(5.4f,15.36f, 2f,12.28f, 2f, 8.5f)},
            Op { p -> p.cubicTo(2f,5.42f, 4.42f,3f, 7.5f,3f)},
            Op { p -> p.cubicTo(9.24f,3f, 10.91f,3.81f, 12f,5.09f)},
            Op { p -> p.cubicTo(13.09f,3.81f, 14.76f,3f, 16.5f,3f)},
            Op { p -> p.cubicTo(19.58f,3f, 22f,5.42f, 22f,8.5f)},
            Op { p -> p.cubicTo(22f, 12.28f, 18.6f,15.36f, 13.45f,20.04f)},
            Op { p -> p.close()}
    )
//    private val CLOUD_OPS = arrayOf(
//            Op { p -> p.moveTo( 119.6f,   195.5f) },
//            Op { p -> p.cubicTo(69.3f,   195.5f, 25.3f,   222.5f,  1.3f,   262.8f) },
//            Op { p -> p.cubicTo(-14.2f,  252.2f, -32.9f,  246f,   -53f,    246f) },
//            Op { p -> p.cubicTo(-106.3f, 246f,   -149.5f, 289.2f, -149.5f, 342.5f) },
//            Op { p -> p.cubicTo(-149.5f, 342.5f, -149.5f, 364f,   -149.5f, 364f) },
//            Op { p -> p.cubicTo(-149.5f, 364f,   257.4f,  364.1f,  257.4f, 364.1f) },
//            Op { p -> p.cubicTo(257.4f,  364.1f, 257.4f,  333.3f,  257.4f, 333.3f) },
//            Op { p -> p.cubicTo(257.4f,  257.2f, 195.7f,  195.5f,  119.6f, 195.5f) },
//            Op { p -> p.close()}
//    )
    private val CLOUD_OPS = arrayOf(
            Op { p -> p.moveTo( -80f,   -5f) },
            Op { p -> p.cubicTo(-130f,  -5f,  -175f,  22f, -200f, 63f) },
            Op { p -> p.cubicTo(-215f,  52f, -230f,  46f,  -253f, 46f) },
            Op { p -> p.cubicTo(-306f,  46f, -350f,  90f,  -350f, 142f) },
            Op { p -> p.cubicTo(-350f,  142f, -350f, 164f, -350f,   164f) },
            Op { p -> p.cubicTo(-350f,  164f, 57f,   164f, 57f, 164f) },
            Op { p -> p.cubicTo(57f,    164f, 57f,   133f, 57f,   133f) },
            Op { p -> p.cubicTo(57f,     57f, -5f,    -5f,   -80f,  -5f) },
            Op { p -> p.close()}
    )

    private val p = Path()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 12f
        color = Color.parseColor("#ff00a699")
    }
    private val matrix = Matrix().apply {
        preTranslate(600f, 300f)
    }
    var count = 0
        set(value) {
            field++
            invalidateSelf()
        }

    override fun draw(canvas: Canvas) {
        p.reset()
        CLOUD_OPS.forEachIndexed { i, op -> if (i <= count) op.op(p) }
        p.transform(matrix)

        canvas.drawPath(p, paint)
    }

    override fun setAlpha(alpha: Int) {
    }

    override fun getOpacity(): Int = 255

    override fun setColorFilter(colorFilter: ColorFilter?) {
    }
}