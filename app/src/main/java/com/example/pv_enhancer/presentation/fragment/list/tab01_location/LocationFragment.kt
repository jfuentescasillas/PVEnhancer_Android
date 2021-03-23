package com.example.pv_enhancer.presentation.fragment.list.tab01_location

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pv_enhancer.R
import com.example.pv_enhancer.databinding.FragmentLocationBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LocationFragment: Fragment() {
    lateinit var binding: FragmentLocationBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLocationBinding.inflate(layoutInflater, container, false)

        setupView()

        return binding.root
    }


    private fun setupView() {

    }
}