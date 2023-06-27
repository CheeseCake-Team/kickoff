package com.cheesecake.presentation.screens.topscorers

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentTopScorersBinding
import com.cheesecake.presentation.screens.league.leagueDetails.LeagueDetailsTopScorersAdapter
import com.cheesecake.presentation.screens.standings.StandingNavigationEvent

class TopScorersFragment : BaseFragment<FragmentTopScorersBinding>() {
    override val layoutIdFragment: Int = R.layout.fragment_top_scorers
    override val viewModel: TopScorersViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
        binding.recyclerViewPlayersGoals.adapter = LeagueDetailsTopScorersAdapter()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: TopScorersNavigationEvent) {
        when (event) {
            is TopScorersNavigationEvent.NavigateBack -> {
                findNavController().navigateUp()
            }
        }
    }

}