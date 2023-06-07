package com.cheesecake.ui.fragment.leagueMatches

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.cheesecake.ui.R
import com.cheesecake.ui.base.BaseFragment
import com.cheesecake.ui.databinding.FragmentTeamsLeagueBinding
import com.cheesecake.ui.fragment.leagueTeams.LeagueTeamsViewModel
import com.cheesecake.ui.fragment.leagueTeams.adapter.TeamsAdapter

class LeagueMatchesFragment : BaseFragment<FragmentTeamsLeagueBinding>() {
    override val layoutIdFragment: Int
        get() = R.layout.fragment_league_matches
    override val viewModel: LeagueMatchesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.teamsRecyclerView.adapter = TeamsAdapter()
    }
}

