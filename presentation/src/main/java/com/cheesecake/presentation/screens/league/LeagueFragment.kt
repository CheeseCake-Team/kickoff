package com.cheesecake.presentation.screens.league

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
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
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch

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
        lifecycleScope.launch {
            viewModel.state.collectLatest { state ->
                val fragments = listOf(
                    LeagueDetailsFragment.newInstance(viewModel.args, state.leagueSeason),
                    LeagueMatchesFragment.newInstance(viewModel.args, state.leagueSeason),
                    LeagueTeamsFragment.newInstance(viewModel.args, state.leagueSeason)
                )
                val fragmentsAdapter = BaseFragmentsAdapter(
                    childFragmentManager,
                    requireActivity().lifecycle,
                    fragments
                )
                binding.leagueViewPager.adapter = fragmentsAdapter
                TabLayoutMediator(binding.tabLayout, binding.leagueViewPager) { tab, position ->
                    when (position) {
                        0 -> tab.text = "Details"
                        1 -> tab.text = "Matches"
                        2 -> tab.text = "Teams"
                    }
                }.attach()

                Log.i("initdscdsdcsdvvs: ", state.leagueSeason.toString())
            }
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