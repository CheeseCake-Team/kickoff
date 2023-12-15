package com.cheesecake.presentation.screens.team.teamMatches

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentTeamMatchesBinding
import com.cheesecake.presentation.screens.team.TeamFragmentDirections
import com.cheesecake.presentation.screens.team.teamMatches.TeamMatchesArgs.Companion.COMPETITION_ID_ARG
import com.cheesecake.presentation.screens.team.teamMatches.TeamMatchesArgs.Companion.SEASON_ARG
import com.cheesecake.presentation.screens.team.teamMatches.TeamMatchesArgs.Companion.TEAM_ID_ARG
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamMatchesFragment : BaseFragment<FragmentTeamMatchesBinding>() {
    override val layoutIdFragment = R.layout.fragment_team_matches
    override val viewModel : TeamMatchesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.matchesRecyclerView.adapter = TeamMatchesAdapter()
        handleNavigation()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: TeamMatchesNavigationEvent) {
        val action = when (event) {
            is TeamMatchesNavigationEvent.MatchClickedEvent ->
                TeamFragmentDirections.actionTeamFragmentToMatchFragment(
                    event.homeTeamId,
                    event.awayTeamId,
                    event.date
                )
        }
        findNavController().navigate(action)
    }

    companion object {
        @JvmStatic
        fun newInstance(teamId: Int, season: Int, competitionId: Int) =
            TeamMatchesFragment().apply {
                arguments = Bundle().apply {
                    putInt(TEAM_ID_ARG, teamId)
                    putInt(SEASON_ARG, season)
                    putInt(COMPETITION_ID_ARG, competitionId)
                }
            }
    }
}