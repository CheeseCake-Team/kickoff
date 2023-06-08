package com.cheesecake.ui.fragment.leagueMatches

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.ui.R
import com.cheesecake.ui.base.BaseFragment
import com.cheesecake.ui.databinding.FragmentTeamsLeagueBinding

class LeagueMatchesFragment : BaseFragment<FragmentTeamsLeagueBinding>() {
    override val layoutIdFragment = R.layout.fragment_league_matches
    override val viewModel: LeagueMatchesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}

