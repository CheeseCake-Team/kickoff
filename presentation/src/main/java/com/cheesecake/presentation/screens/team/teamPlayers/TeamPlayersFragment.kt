package com.cheesecake.presentation.screens.team.teamPlayers

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentTeamPlayersBinding
import com.cheesecake.presentation.screens.team.TeamFragmentDirections
import com.cheesecake.presentation.screens.team.teamPlayers.TeamPlayersArgs.Companion.SEASON_ARG
import com.cheesecake.presentation.screens.team.teamPlayers.TeamPlayersArgs.Companion.TEAM_ID_ARG
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamPlayersFragment : BaseFragment<FragmentTeamPlayersBinding>() {
    override val layoutIdFragment = R.layout.fragment_team_players
    override val viewModel: TeamPlayersViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
        binding.playerRecyclerView.adapter = TeamPlayersPositionsAdapter()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: TeamPLayerNavigationEvent) {
        when (event) {
            is TeamPLayerNavigationEvent.NavigateToPlayer -> {
                findNavController().navigate(
                    TeamFragmentDirections.actionTeamFragmentToPlayerFragment(
                        event.playerId,
                        event.season
                    )
                )
            }

            else -> {}
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(teakId: Int, season: Int) =
            TeamPlayersFragment().apply {
                arguments = Bundle().apply {
                    putInt(TEAM_ID_ARG, teakId)
                    putInt(SEASON_ARG, season)
//                    putInt(MatchEventArgs.HOME_TEAM_ID_ARG, homeTeamID)
//                    putInt(MatchEventArgs.AWAY_TEAM_ID_ARG, awayTeamId)
                }
            }
    }

}