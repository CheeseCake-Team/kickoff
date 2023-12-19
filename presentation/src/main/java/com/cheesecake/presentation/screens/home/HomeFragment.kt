package com.cheesecake.presentation.screens.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val layoutIdFragment = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeRecyclerViews()
        handleNavigation()
    }

    private fun initializeRecyclerViews() {
        binding.dateRecyclerView.apply {
            adapter = DateAdapter()
            scrollToPosition(viewModel.state.value.currentDatePosition)
        }
        binding.favoriteLeagueMatchesRecyclerView.adapter = HomeAdapter()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: HomeEvents) {
        val action = when (event) {
            is HomeEvents.NavigateToMatch ->
                HomeFragmentDirections.actionHomeFragmentToMatchFragment(
                    event.homeTeamId,
                    event.awayTeamId,
                    event.date
                )

            is HomeEvents.NavigateToCompetition -> HomeFragmentDirections
                .actionHomeFragmentToLeagueFragment(event.competitionId)
        }
        findNavController().navigate(action)
    }
}