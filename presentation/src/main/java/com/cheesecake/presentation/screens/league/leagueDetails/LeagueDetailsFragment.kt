package com.cheesecake.presentation.screens.league.leagueDetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentLeagueDetailsBinding
import com.cheesecake.presentation.screens.league.LeagueArgs.Companion.LEAGUE_ID_ARG
import com.cheesecake.presentation.screens.league.LeagueArgs.Companion.SEASON_ARG
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

    companion object {
        @JvmStatic
        fun newInstance(leagueID: Int, season: Int) = LeagueDetailsFragment().apply {
            arguments = Bundle().apply {
                putInt(LEAGUE_ID_ARG, leagueID)
                putInt(SEASON_ARG, season)
            }
        }
    }
}