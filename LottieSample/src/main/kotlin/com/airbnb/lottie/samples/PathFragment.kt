package com.airbnb.lottie.samples

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_paths.view.*

class PathFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = container!!.inflate(R.layout.fragment_paths, false)
        val d = PathDrawable()
        view.imageView.setImageDrawable(d)
        view.imageView.setOnClickListener { d.count++ }
        return view
    }

    companion object {
        internal fun newInstance(): PathFragment = PathFragment()
    }
}