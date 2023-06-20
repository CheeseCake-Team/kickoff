package com.cheesecake.presentation.screens.team

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.base.BaseFragmentsAdapter
import com.cheesecake.presentation.databinding.FragmentTeamBinding
import com.cheesecake.presentation.screens.team.teamMatches.TeamMatchesFragment
import com.cheesecake.presentation.screens.team.teamPlayers.TeamPlayersFragment
import com.cheesecake.presentation.screens.team.teamstatistics.TeamStatisticsFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamFragment: BaseFragment<FragmentTeamBinding>() {
    override val layoutIdFragment = R.layout.fragment_team
    override val viewModel: TeamViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val fragments = listOf(
            TeamPlayersFragment(),
            TeamMatchesFragment(),
            TeamStatisticsFragment(),
        )
        val fragmentsAdapter = BaseFragmentsAdapter((activity as AppCompatActivity), fragments)
        binding.teamViewPager.adapter = fragmentsAdapter
        TabLayoutMediator(binding.tabLayout, binding.teamViewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Players"
                1 -> tab.text = "Matches"
                2 -> tab.text = "Statistic"
            }
        }.attach()
    }

}