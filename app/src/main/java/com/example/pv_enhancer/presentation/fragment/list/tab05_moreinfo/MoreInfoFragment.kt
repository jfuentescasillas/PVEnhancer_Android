package com.example.pv_enhancer.presentation.fragment.list.tab05_moreinfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pv_enhancer.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MoreInfoFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more_info, container, false)
    }
}