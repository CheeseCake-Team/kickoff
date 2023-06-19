package com.cheesecake.presentation.screens.league.leagueTeams

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentTeamsLeagueBinding
import com.cheesecake.presentation.screens.league.LeagueArgs
import com.cheesecake.presentation.screens.league.leagueMatches.LeagueMatchesFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LeagueTeamsFragment : BaseFragment<FragmentTeamsLeagueBinding>() {
    override val layoutIdFragment = R.layout.fragment_teams_league
    override val viewModel: LeagueTeamsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.teamsRecyclerView.adapter = TeamsAdapter()
    }

    companion object {
        @JvmStatic
        fun newInstance(leagueID: Int, season: Int) = LeagueTeamsFragment().apply {
            arguments = Bundle().apply {
                putInt(LeagueArgs.LEAGUE_ID_ARG, leagueID)
                putInt(LeagueArgs.SEASON_ARG, season)
            }
        }

    }
}