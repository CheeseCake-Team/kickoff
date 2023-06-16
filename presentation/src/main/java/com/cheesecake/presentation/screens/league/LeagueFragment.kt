package com.cheesecake.presentation.screens.league

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.base.BaseFragmentsAdapter
import com.cheesecake.presentation.databinding.FragmentLeagueBinding
import com.cheesecake.presentation.screens.leagueDetails.LeagueDetailsFragment
import com.cheesecake.presentation.screens.leagueMatches.LeagueMatchesFragment
import com.cheesecake.presentation.screens.leagueTeams.LeagueTeamsFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LeagueFragment : BaseFragment<FragmentLeagueBinding>() {
    override val layoutIdFragment = R.layout.fragment_league
    override val viewModel: LeagueViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val fragments = listOf(
            LeagueDetailsFragment(),
            LeagueMatchesFragment(),
            LeagueTeamsFragment(),
        )
        val fragmentsAdapter = BaseFragmentsAdapter((activity as AppCompatActivity), fragments)
        binding.leagueViewPager.adapter = fragmentsAdapter
        TabLayoutMediator(binding.tabLayout, binding.leagueViewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Details"
                1 -> tab.text = "Matches"
                2 -> tab.text = "Teams"
            }
        }.attach()
    }

}