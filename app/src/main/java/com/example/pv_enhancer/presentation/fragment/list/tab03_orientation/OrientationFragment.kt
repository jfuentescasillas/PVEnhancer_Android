package com.example.pv_enhancer.presentation.fragment.list.tab03_orientation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pv_enhancer.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class OrientationFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_orientation, container, false)
    }
}