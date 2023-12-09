package com.cheesecake.presentation.screens.competition

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.base.BaseFragmentsAdapter
import com.cheesecake.presentation.databinding.FragmentCompetitionBinding
import com.cheesecake.presentation.screens.competition.competitiondetails.CompetitionDetailsFragment
import com.cheesecake.presentation.screens.competition.competitionmatches.CompetitionMatchesFragment
import com.cheesecake.presentation.screens.competition.competitionteams.CompetitionTeamsFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CompetitionFragment : BaseFragment<FragmentCompetitionBinding>() {
    override val layoutIdFragment = R.layout.fragment_competition
    override val viewModel: CompetitionViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
        init()
    }

    private fun init() {
        lifecycleScope.launch {
            viewModel.state.collectLatest { state ->
                val fragments = listOf(
                    CompetitionDetailsFragment.newInstance(viewModel.competitionId, state.competitionSeason),
                    CompetitionMatchesFragment.newInstance(viewModel.competitionId, state.competitionSeason),
                    CompetitionTeamsFragment.newInstance(viewModel.competitionId, state.competitionSeason)
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
                handleOnError(state.errorMessage)
            }
        }
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: CompetitionNavigationEvent) {
        when (event) {
            is CompetitionNavigationEvent.NavigateBack -> {
                findNavController().navigateUp()
            }
        }
    }
}