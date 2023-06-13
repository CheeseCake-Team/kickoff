package com.cheesecake.presentation.ui.leagueMatches

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentLeagueMatchesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LeagueMatchesFragment : BaseFragment<FragmentLeagueMatchesBinding>() {
    override val layoutIdFragment = R.layout.fragment_league_matches
    override val viewModel: LeagueMatchesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.matchesRecyclerView.adapter = LeagueMatchesDateMatchAdapter()
    }
}

