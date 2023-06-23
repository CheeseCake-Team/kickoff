package com.cheesecake.presentation.screens.team.teamPlayers

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentTeamPlayersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamPlayersFragment : BaseFragment<FragmentTeamPlayersBinding>() {

    override val layoutIdFragment = R.layout.fragment_team_players
    override val viewModel: TeamPlayersViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.playerRecyclerView.adapter = TeamPLayersPositionsAdapter()
    }
}