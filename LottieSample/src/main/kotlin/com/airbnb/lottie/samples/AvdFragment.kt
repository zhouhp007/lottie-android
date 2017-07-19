package com.airbnb.lottie.samples

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.annotation.DrawableRes
import android.support.graphics.drawable.Animatable2Compat
import android.support.graphics.drawable.AnimatedVectorDrawableCompat
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.fragment_avd.view.*

class AvdFragment : Fragment() {
    private val DRAWABLES = arrayOf(
            R.drawable.adrock,
            R.drawable.bacon_pancakes,
            R.drawable.mca,
            R.drawable.miked,
            R.drawable.test
    )

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = container!!.inflate(R.layout.fragment_avd, false)

        for (drawable in DRAWABLES) {
            view.linearLayout.addView(createAvdView(drawable))
        }

        return view
    }

    private fun createAvdView(@DrawableRes drawable: Int): ImageView {
        val avdView = ImageView(context)
        avdView.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        )
        val avd = AnimatedVectorDrawableCompat.create(context, drawable) as AnimatedVectorDrawableCompat
        avd.registerAnimationCallback(object: Animatable2Compat.AnimationCallback() {
            override fun onAnimationEnd(drawable: Drawable) {
                avdView.postDelayed( { avd.start() }, 1000)
            }
        })
        avdView.post { avd.start() }
        avdView.setImageDrawable(avd)
        avdView.setMargin(0, 0, 0, 24)
        return avdView
    }

    companion object {
        internal fun newInstance(): AvdFragment {
            return AvdFragment()
        }
    }
}