package com.cheesecake.presentation.screens.league.leagueMatches

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentLeagueMatchesBinding
import com.cheesecake.presentation.screens.home.HomeEvents
import com.cheesecake.presentation.screens.home.HomeFragmentDirections
import com.cheesecake.presentation.screens.league.LeagueArgs
import com.cheesecake.presentation.screens.league.LeagueFragmentDirections
import com.cheesecake.presentation.screens.league.leagueDetails.LeagueDetailsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LeagueMatchesFragment : BaseFragment<FragmentLeagueMatchesBinding>() {
    override val layoutIdFragment = R.layout.fragment_league_matches
    override val viewModel: LeagueMatchesViewModel by viewModels()

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

    private fun onEvent(event: LeagueMatchesEvent) {
        val action = when (event) {
            is LeagueMatchesEvent.MatchClickedEvent ->
                LeagueFragmentDirections.actionLeagueFragmentToMatchFragment(
                    event.homeTeamId,
                    event.awayTeamId,
                    event.date
                )

        }
        findNavController().navigate(action)
    }
    companion object {
        @JvmStatic
        fun newInstance(leagueID: Int, season: Int) = LeagueMatchesFragment().apply {
            arguments = Bundle().apply {
                putInt(LeagueArgs.LEAGUE_ID_ARG, leagueID)
                putInt(LeagueArgs.SEASON_ARG, season)
            }
        }
    }
}

