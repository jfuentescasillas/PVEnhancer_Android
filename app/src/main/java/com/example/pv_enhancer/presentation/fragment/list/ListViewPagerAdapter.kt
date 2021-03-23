package com.example.pv_enhancer.presentation.fragment.list

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pv_enhancer.presentation.fragment.list.tab01_location.LocationFragment
import com.example.pv_enhancer.presentation.fragment.list.tab02_irradiance.IrradianceFragment
import com.example.pv_enhancer.presentation.fragment.list.tab03_orientation.OrientationFragment


class ListViewPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LocationFragment()
            1 -> IrradianceFragment()
            2 -> OrientationFragment()
            else -> Fragment()
        }
    }
}