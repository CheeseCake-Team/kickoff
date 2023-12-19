package com.cheesecake.presentation.screens.team.teamstatistics

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentTeamStatisticsBinding
import com.cheesecake.presentation.screens.team.teamstatistics.TeamStatisticsArgs.Companion.COMPETITION_ID_ARG
import com.cheesecake.presentation.screens.team.teamstatistics.TeamStatisticsArgs.Companion.SEASON_ARG

import com.cheesecake.presentation.screens.team.teamstatistics.TeamStatisticsArgs.Companion.TEAM_ID_ARG
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamStatisticsFragment : BaseFragment<FragmentTeamStatisticsBinding>() {
    override val layoutIdFragment = R.layout.fragment_team_statistics
    override val viewModel: TeamStatisticsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerForm.adapter = TeamStatisticsFormAdapter()
    }

    companion object {
        @JvmStatic
        fun newInstance(teamId: Int, competitionId: Int, season: Int) =
            TeamStatisticsFragment().apply {
                arguments = Bundle().apply {
                    putInt(TEAM_ID_ARG, teamId)
                    putInt(COMPETITION_ID_ARG, competitionId)
                    putInt(SEASON_ARG, season)
                }
            }
    }
}