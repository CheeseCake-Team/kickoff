package com.cheesecake.presentation.screens.competition.competitionteams

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentCompetitionTeamsBinding
import com.cheesecake.presentation.screens.competition.CompetitionArgs
import com.cheesecake.presentation.screens.competition.CompetitionFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CompetitionTeamsFragment : BaseFragment<FragmentCompetitionTeamsBinding>() {
    override val layoutIdFragment = R.layout.fragment_competition_teams
    override val viewModel: CompetitionTeamsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.teamsRecyclerView.adapter = CompetitionTeamsAdapter()
        handleNavigation()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: CompetitionTeamsEvent) {
        val action = when (event) {
            is CompetitionTeamsEvent.TeamClickEvent ->
                CompetitionFragmentDirections.actionLeagueFragmentToTeamFragment(event.teamId)
        }
        findNavController().navigate(action)
    }

    companion object {
        @JvmStatic
        fun newInstance(leagueID: Int, season: Int) = CompetitionTeamsFragment().apply {
            arguments = Bundle().apply {
                putInt(CompetitionArgs.COMPETITION_ID_ARG, leagueID)
                putInt(CompetitionArgs.SEASON_ARG, season)
            }
        }
    }
}