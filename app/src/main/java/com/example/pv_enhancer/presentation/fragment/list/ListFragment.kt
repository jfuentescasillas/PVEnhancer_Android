package com.example.pv_enhancer.presentation.fragment.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pv_enhancer.R
import com.example.pv_enhancer.base.BaseExtraData
import com.example.pv_enhancer.base.BaseFragment
import com.example.pv_enhancer.databinding.FragmentListBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ListFragment: BaseFragment<ListState, ListViewModel, FragmentListBinding>() {
    /**
     * Base Classes Variables
     */
    override val viewModelClass = ListViewModel::class.java
    lateinit var vm: ListViewModel
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentListBinding = FragmentListBinding::inflate



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    /**
     * Base Class methods
     */
    override fun setupView(viewModel: ListViewModel) {
        vm = viewModel
    }

    override fun onNormal(data: ListState) {
        binding.listFragmentViewPager2.adapter = ListViewPagerAdapter(this)

        TabLayoutMediator(binding.listFragmentTabLayout, binding.listFragmentViewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.setIcon(R.drawable.ic_tab01_placeholder)
                    tab.text = getString(R.string.tab01_title_location)//getString(R.string.CharacterDetailFragmentTabTitleComics)
                }

                1 -> {
                    tab.setIcon(R.drawable.ic_tab02_irradiance)
                    tab.text = getString(R.string.tab02_title_irradiance)//getString(R.string.CharacterDetailFragmentTabTitleSeries)
                }

                2 -> {
                    tab.setIcon(R.drawable.ic_tab03_orientation)
                    tab.text = getString(R.string.tab03_title_orientation)//getString(R.string.CharacterDetailFragmentTabTitleStories)
                }

                3 -> {
                    tab.setIcon(R.drawable.ic_tab04_estimation)
                    tab.text = getString(R.string.tab04_title_estimation)//getString(R.string.CharacterDetailFragmentTabTitleStories)
                }

                4 -> {
                    tab.setIcon(R.drawable.ic_tab05_info)
                    tab.text = getString(R.string.tab05_title_more_info)//getString(R.string.CharacterDetailFragmentTabTitleStories)
                }
            }
        }.attach()
    }


    override fun onLoading(dataLoading: BaseExtraData?) {

    }


    override fun onError(dataError: Throwable) {

    }
}