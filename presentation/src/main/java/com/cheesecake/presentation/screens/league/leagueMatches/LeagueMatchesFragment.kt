package com.cheesecake.presentation.screens.league.leagueMatches

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentLeagueMatchesBinding
import com.cheesecake.presentation.screens.league.LeagueArgs
import com.cheesecake.presentation.screens.league.leagueDetails.LeagueDetailsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LeagueMatchesFragment : BaseFragment<FragmentLeagueMatchesBinding>() {
    override val layoutIdFragment = R.layout.fragment_league_matches
    override val viewModel: LeagueMatchesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.matchesRecyclerView.adapter = DateMatchesAdapter()
    }
    companion object {
        @JvmStatic
        fun newInstance(leagueID: Int, season: Int) = LeagueMatchesFragment().apply {
            arguments = Bundle().apply {
                putInt(LeagueArgs.LEAGUE_ID_ARG, leagueID)
                putInt(LeagueArgs.SEASON_ARG, season)
            }
        }
    }
}

