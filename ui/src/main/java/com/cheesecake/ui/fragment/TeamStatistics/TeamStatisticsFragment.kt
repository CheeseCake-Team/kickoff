package com.cheesecake.ui.fragment.TeamStatistics

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.ui.R
import com.cheesecake.ui.base.BaseFragment
import com.cheesecake.ui.databinding.FragmentTeamsLeagueBinding
import com.cheesecake.ui.fragment.leagueTeams.adapter.TeamsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TestFragment : BaseFragment<FragmentTeamsLeagueBinding>() {
    override val layoutIdFragment: Int
        get() = R.layout.fragment_team_statistics
    override val viewModel: TeamStatisticsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.teamsRecyclerView.adapter = TeamsAdapter()
    }

}