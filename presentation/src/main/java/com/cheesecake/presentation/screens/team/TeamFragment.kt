package com.cheesecake.presentation.screens.team

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.base.BaseFragmentsAdapter
import com.cheesecake.presentation.databinding.FragmentLeagueBinding
import com.cheesecake.presentation.databinding.FragmentTeamBinding
import com.cheesecake.presentation.screens.league.LeagueViewModel
import com.cheesecake.presentation.screens.leagueDetails.LeagueDetailsFragment
import com.cheesecake.presentation.screens.leagueMatches.LeagueMatchesFragment
import com.cheesecake.presentation.screens.leagueTeams.LeagueTeamsFragment
import com.cheesecake.presentation.screens.teamMatches.TeamMatchFragment
import com.cheesecake.presentation.screens.teamPlayers.TeamPlayerFragment
import com.cheesecake.presentation.screens.teamstatistics.TeamStatisticsFragment
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
            TeamStatisticsFragment(),
            TeamMatchFragment(),
            TeamPlayerFragment(),
        )
        val fragmentsAdapter = BaseFragmentsAdapter((activity as AppCompatActivity), fragments)
        binding.teamViewPager.adapter = fragmentsAdapter
        TabLayoutMediator(binding.tabLayout, binding.teamViewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Statistics"
                1 -> tab.text = "Matches"
                2 -> tab.text = "Players"
            }
        }.attach()
    }

}
