package com.cheesecake.presentation.screens.competition.competitiondetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentCompetitionDetailsBinding
import com.cheesecake.presentation.screens.competition.CompetitionArgs.Companion.COMPETITION_ID_ARG
import com.cheesecake.presentation.screens.competition.CompetitionArgs.Companion.SEASON_ARG
import com.cheesecake.presentation.screens.competition.CompetitionFragmentDirections
import com.google.android.material.divider.MaterialDividerItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CompetitionDetailsFragment : BaseFragment<FragmentCompetitionDetailsBinding>() {
    override val layoutIdFragment = R.layout.fragment_competition_details
    override val viewModel: CompetitionDetailsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
        initializeRecyclerViews()
    }

    private fun initializeRecyclerViews() {
        binding.recyclerViewTeamsStanding.apply {
            adapter = CompetitionDetailsStandingAdapter()
            addItemDecoration(MaterialDividerItemDecoration(context, DividerItemDecoration.VERTICAL)
                .apply {
                    isLastItemDecorated = false
                }
            )
        }
        binding.recyclerViewPlayersGoals.apply {
            adapter = CompetitionDetailsTopScorersAdapter()
            addItemDecoration(MaterialDividerItemDecoration(context, DividerItemDecoration.VERTICAL)
                .apply {
                    isLastItemDecorated = false
                }
            )
        }
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: CompetitionDetailsEvents) {
        when (event) {
            is CompetitionDetailsEvents.NavigateToTeamsStanding -> {
                findNavController().navigate(
                    CompetitionFragmentDirections.actionLeagueFragmentToStandingsFragment(
                        event.leagueId, event.season
                    )
                )
            }

            is CompetitionDetailsEvents.NavigateToTopPlayer -> {
                findNavController().navigate(
                    CompetitionFragmentDirections.actionLeagueFragmentToTopScorersFragment(
                        event.leagueId, event.season
                    )
                )
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(leagueID: Int, season: Int) = CompetitionDetailsFragment().apply {
            arguments = Bundle().apply {
                putInt(COMPETITION_ID_ARG, leagueID)
                putInt(SEASON_ARG, season)
            }
        }
    }
}