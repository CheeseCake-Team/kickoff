package com.cheesecake.presentation.screens.league

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.base.BaseFragmentsAdapter
import com.cheesecake.presentation.databinding.FragmentLeagueBinding
import com.cheesecake.presentation.databinding.FragmentStandingsBinding
import com.cheesecake.presentation.screens.leagueDetails.LeagueDetailsFragment
import com.cheesecake.presentation.screens.leagueMatches.LeagueMatchesFragment
import com.cheesecake.presentation.screens.leagueTeams.LeagueTeamsFragment
import com.cheesecake.presentation.screens.standings.StandingsAdapter
import com.cheesecake.presentation.screens.standings.StandingsViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LeagueFragment : BaseFragment<FragmentStandingsBinding>() {
    override val layoutIdFragment = R.layout.fragment_standings
    override val viewModel: StandingsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerviewStandings.adapter = StandingsAdapter()
    }
}