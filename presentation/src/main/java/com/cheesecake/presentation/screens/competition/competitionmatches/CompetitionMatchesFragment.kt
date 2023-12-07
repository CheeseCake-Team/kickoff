package com.cheesecake.presentation.screens.competition.competitionmatches

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentCompetitionMatchesBinding
import com.cheesecake.presentation.screens.competition.CompetitionArgs
import com.cheesecake.presentation.screens.competition.CompetitionFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CompetitionMatchesFragment : BaseFragment<FragmentCompetitionMatchesBinding>() {
    override val layoutIdFragment = R.layout.fragment_competition_matches
    override val viewModel: CompetitionMatchesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.matchesRecyclerView.adapter = DateMatchesAdapter()
        handleNavigation()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: CompetitionMatchesEvent) {
        val action = when (event) {
            is CompetitionMatchesEvent.MatchClickedEvent ->
                CompetitionFragmentDirections.actionLeagueFragmentToMatchFragment(
                    event.homeTeamId,
                    event.awayTeamId,
                    event.date
                )

        }
        findNavController().navigate(action)
    }

    companion object {
        @JvmStatic
        fun newInstance(leagueID: Int, season: Int) = CompetitionMatchesFragment().apply {
            arguments = Bundle().apply {
                putInt(CompetitionArgs.COMPETITION_ID_ARG, leagueID)
                putInt(CompetitionArgs.SEASON_ARG, season)
            }
        }
    }
}