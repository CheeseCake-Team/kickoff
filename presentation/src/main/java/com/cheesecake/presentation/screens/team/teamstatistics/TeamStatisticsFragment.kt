package com.cheesecake.presentation.screens.team.teamstatistics

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentTeamStatisticsBinding
import com.cheesecake.presentation.screens.league.leagueTeams.TeamsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamStatisticsFragment : BaseFragment<FragmentTeamStatisticsBinding>() {
    override val layoutIdFragment = R.layout.fragment_team_statistics
    override val viewModel: TeamStatisticsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerForm.adapter = TeamStatisticsFormAdapter()
    }

}