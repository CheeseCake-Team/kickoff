package com.cheesecake.presentation.screens.match

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.base.BaseFragmentsAdapter
import com.cheesecake.presentation.databinding.FragmentMatchBinding
import com.cheesecake.presentation.screens.match.events.MatchEventFragment
import com.cheesecake.presentation.screens.match.lineup.MatchLineupFragment
import com.cheesecake.presentation.ui.match.statistics.MatchStatisticsFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchFragment : BaseFragment<FragmentMatchBinding>() {
    override val layoutIdFragment = R.layout.fragment_match
    override val viewModel: MatchViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val fragments = listOf(
            MatchStatisticsFragment(),
            MatchEventFragment(),
            MatchLineupFragment(),
        )
        val fragmentsAdapter = BaseFragmentsAdapter((activity as AppCompatActivity), fragments)
        binding.matchViewPager.adapter = fragmentsAdapter
        TabLayoutMediator(binding.tabLayout, binding.matchViewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Statistics"
                1 -> tab.text = "Events"
                2 -> tab.text = "Lineup"
            }
        }.attach()
    }
}