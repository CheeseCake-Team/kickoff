package com.cheesecake.presentation.screens.league

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.base.BaseFragmentsAdapter
import com.cheesecake.presentation.databinding.FragmentLeagueBinding
import com.cheesecake.presentation.screens.league.leagueDetails.LeagueDetailsFragment
import com.cheesecake.presentation.screens.league.leagueMatches.LeagueMatchesFragment
import com.cheesecake.presentation.screens.league.leagueTeams.LeagueTeamsFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LeagueFragment : BaseFragment<FragmentLeagueBinding>() {
    override val layoutIdFragment = R.layout.fragment_league
    override val viewModel: LeagueViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleNavigation()
        init()
    }

    private fun init() {
        collect(viewModel.leagueId){
            val fragments = listOf(
                LeagueDetailsFragment.newInstance(it, 2022),
                LeagueMatchesFragment.newInstance(it, 2022),
                LeagueTeamsFragment.newInstance(it, 2022),
            )
            val fragmentsAdapter = BaseFragmentsAdapter(childFragmentManager,
                requireActivity().lifecycle,fragments)
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

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: LeagueNavigationEvent) {
        when (event) {
            is LeagueNavigationEvent.NavigateBack -> {
                findNavController().navigateUp()
            }
        }
    }

}