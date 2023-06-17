package com.cheesecake.presentation.screens.teamMatches

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentTeamMatchesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamMatchFragment : BaseFragment<FragmentTeamMatchesBinding>() {
    override val layoutIdFragment = R.layout.fragment_team_matches
    override val viewModel : TeamMatchesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.matchesRecyclerView.adapter = TeamMatchesDateAdapter()
    }
}