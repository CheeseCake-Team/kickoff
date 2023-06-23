package com.cheesecake.presentation.screens.team.teamMatches

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentTeamMatchesBinding
import com.cheesecake.presentation.screens.team.teamMatches.TeamMatchesArgs.Companion.TEAM_ID_ARG
import com.cheesecake.presentation.screens.team.teamPlayers.TeamPlayersFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamMatchesFragment : BaseFragment<FragmentTeamMatchesBinding>() {
    override val layoutIdFragment = R.layout.fragment_team_matches
    override val viewModel : TeamMatchesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.matchesRecyclerView.adapter = TeamMatchesAdapter()
    }

    companion object {
        @JvmStatic
        fun newInstance(teamId: Int) =
            TeamMatchesFragment().apply {
                arguments = Bundle().apply {
                    putInt(TEAM_ID_ARG, teamId)
//                    putInt(MatchEventArgs.HOME_TEAM_ID_ARG, homeTeamID)
//                    putInt(MatchEventArgs.AWAY_TEAM_ID_ARG, awayTeamId)
                }
            }
    }

}