package com.cheesecake.ui.ui.leagueDetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.ui.R
import com.cheesecake.ui.base.BaseFragment
import com.cheesecake.ui.databinding.FragmentLeagueDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LeagueDetailsFragment: BaseFragment<FragmentLeagueDetailsBinding>() {

    override val layoutIdFragment = R.layout.fragment_league_details
    override val viewModel: LeagueDetailsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewClubsScores.adapter = LeagueDetailsStandingAdapter()
        binding.recyclerViewPlayersGoals.adapter = LeagueDetailsTopScorersAdapter()
    }

}