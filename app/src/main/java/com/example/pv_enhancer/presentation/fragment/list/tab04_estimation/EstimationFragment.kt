package com.example.pv_enhancer.presentation.fragment.list.tab04_estimation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pv_enhancer.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class EstimationFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_estimation, container, false)
    }
}