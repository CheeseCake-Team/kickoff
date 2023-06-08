package com.cheesecake.ui.fragment.leagueTeams

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.ui.R
import com.cheesecake.ui.base.BaseFragment
import com.cheesecake.ui.databinding.FragmentTeamsLeagueBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LeagueTeamsFragment : BaseFragment<FragmentTeamsLeagueBinding>() {
    override val layoutIdFragment = R.layout.fragment_teams_league
    override val viewModel: LeagueTeamsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.teamsRecyclerView.adapter = TeamsAdapter()
    }

}