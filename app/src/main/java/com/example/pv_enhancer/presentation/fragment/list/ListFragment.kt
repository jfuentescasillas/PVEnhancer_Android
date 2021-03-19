package com.example.pv_enhancer.presentation.fragment.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.pv_enhancer.databinding.FragmentListBinding


class ListFragment: Fragment() {
    lateinit var binding: FragmentListBinding
    private val vm: ListViewModel by viewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentListBinding.inflate(layoutInflater, container, false)
        vm.requestInformation()

        return binding.root
    }
}