package com.cheesecake.presentation.ui.search

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentSearchBinding
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    private lateinit var tabLayout: TabLayout
    override val layoutIdFragment = R.layout.fragment_search
    override val viewModel: SearchViewModel by viewModels()


    @RequiresApi(Build.VERSION_CODES.R)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupStatusBar()
        binding.searchRecyclerView.adapter = SearchFragmentAdapter()
        tabLayout = binding.tabLayout
        setUpTapLayout()

    }

    private fun setupStatusBar() {
        val statusBarColor = ContextCompat.getColor(requireContext(), R.color.cardSurface)
        requireActivity().window.statusBarColor = statusBarColor
    }

    private fun setUpTapLayout() {
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val selectedTabPosition = tab.position
                updateRecyclerView(selectedTabPosition)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        tabLayout.addTab(tabLayout.newTab().setText("Teams"))
        tabLayout.addTab(tabLayout.newTab().setText("Leagues"))

        tabLayout.getTabAt(0)?.select()

    }

    private fun updateRecyclerView(selectedTabPosition: Int) {
        when (selectedTabPosition) {
            0 -> {
                viewModel.searchType.value = SearchType.TEAM
                binding.searchRecyclerView.adapter = SearchFragmentAdapter()
            }
            1 -> {
                viewModel.searchType.value = SearchType.LEAGUE
                TODO()
            }
        }
    }

}













