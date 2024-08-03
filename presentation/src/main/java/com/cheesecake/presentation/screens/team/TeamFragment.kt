package com.cheesecake.presentation.screens.team

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.base.BaseFragmentsAdapter
import com.cheesecake.presentation.databinding.FragmentTeamBinding
import com.cheesecake.presentation.screens.team.teamMatches.TeamMatchesFragment
import com.cheesecake.presentation.screens.team.teamPlayers.TeamPlayersFragment
import com.cheesecake.presentation.screens.team.teamstatistics.TeamStatisticsFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamFragment : BaseFragment<FragmentTeamBinding>() {
    override val layoutIdFragment = R.layout.fragment_team
    override val viewModel: TeamViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeTabLayout()
        handleNavigation()
    }

    private fun initializeTabLayout() {
        val fragments = listOf(
            TeamStatisticsFragment.newInstance(
                viewModel.teamNavigationArgs.teamId,
                viewModel.teamNavigationArgs.competitionId,
                viewModel.teamNavigationArgs.season,
            ),
            TeamMatchesFragment.newInstance(
                viewModel.teamNavigationArgs.teamId,
                viewModel.teamNavigationArgs.season,
                viewModel.teamNavigationArgs.competitionId
            ),
            TeamPlayersFragment.newInstance(
                viewModel.teamNavigationArgs.teamId,
                viewModel.teamNavigationArgs.season
            ),
        )
        val fragmentsAdapter = BaseFragmentsAdapter(
            childFragmentManager,
            requireActivity().lifecycle, fragments
        )
        binding.teamViewPager.adapter = fragmentsAdapter
        TabLayoutMediator(binding.tabLayout, binding.teamViewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Statistic"
                1 -> tab.text = "Matches"
                2 -> tab.text = "Players"
            }
        }.attach()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: TeamNavigationEvent) {
        when (event) {
            is TeamNavigationEvent.NavigateBack -> findNavController().navigateUp()
        }
    }
}