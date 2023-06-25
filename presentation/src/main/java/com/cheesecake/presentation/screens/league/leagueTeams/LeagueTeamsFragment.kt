package com.cheesecake.presentation.screens.league.leagueTeams

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentTeamsLeagueBinding
import com.cheesecake.presentation.screens.home.HomeEvents
import com.cheesecake.presentation.screens.home.HomeFragmentDirections
import com.cheesecake.presentation.screens.league.LeagueArgs
import com.cheesecake.presentation.screens.league.LeagueFragmentDirections
import com.cheesecake.presentation.screens.league.leagueMatches.LeagueMatchesFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LeagueTeamsFragment : BaseFragment<FragmentTeamsLeagueBinding>() {
    override val layoutIdFragment = R.layout.fragment_teams_league
    override val viewModel: LeagueTeamsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.teamsRecyclerView.adapter = TeamsAdapter()
        handleNavigation()
    }


    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: LeagueTeamsEvent) {
        val action = when (event) {
            is LeagueTeamsEvent.TeamClickEvent ->
                LeagueFragmentDirections.actionLeagueFragmentToTeamFragment(event.teamId)
        }
        findNavController().navigate(action)
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