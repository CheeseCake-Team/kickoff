package com.cheesecake.ui.ui.leagueMatches

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.ui.R
import com.cheesecake.ui.base.BaseFragment
import com.cheesecake.ui.databinding.FragmentLeagueMatchesBinding
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

