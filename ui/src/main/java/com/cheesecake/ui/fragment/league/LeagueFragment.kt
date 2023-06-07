package com.cheesecake.ui.fragment.league

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.cheesecake.ui.R
import com.cheesecake.ui.base.BaseFragment
import com.cheesecake.ui.base.BaseFragmentsAdapter
import com.cheesecake.ui.databinding.FragmentLeagueBinding
import com.cheesecake.ui.fragment.leagueTeams.LeagueTeamsFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LeagueFragment : BaseFragment<FragmentLeagueBinding>() {
    override val layoutIdFragment: Int
        get() = R.layout.fragment_league
    override val viewModel: LeagueViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val fragments = listOf(
            LeagueTeamsFragment(),
            LeagueTeamsFragment(),
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