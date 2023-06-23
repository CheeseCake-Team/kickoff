package com.cheesecake.presentation.screens.team.teamPlayers

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentTeamPlayersBinding
import com.cheesecake.presentation.screens.match.events.MatchEventArgs
import com.cheesecake.presentation.screens.match.events.MatchEventFragment
import com.cheesecake.presentation.screens.team.teamPlayers.TeamPlayersArgs.Companion.TEAM_ID_ARG
import com.cheesecake.presentation.screens.team.teamstatistics.TeamStatisticsArgs
import com.cheesecake.presentation.screens.team.teamstatistics.TeamStatisticsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamPlayersFragment : BaseFragment<FragmentTeamPlayersBinding>() {

    override val layoutIdFragment = R.layout.fragment_team_players
    override val viewModel: TeamPlayersViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.playerRecyclerView.adapter = TeamPLayersPositionsAdapter()
    }

    companion object {
        @JvmStatic
        fun newInstance(teakId: Int) =
            TeamPlayersFragment().apply {
                arguments = Bundle().apply {
                    putInt(TEAM_ID_ARG, teakId)
//                    putInt(MatchEventArgs.HOME_TEAM_ID_ARG, homeTeamID)
//                    putInt(MatchEventArgs.AWAY_TEAM_ID_ARG, awayTeamId)
                }
            }
    }

}