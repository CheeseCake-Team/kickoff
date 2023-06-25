package com.cheesecake.presentation.screens.search.viewAll.teams

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentTeamsSearchBinding
import com.cheesecake.presentation.screens.search.SearchEvents
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamsSearchFragment : BaseFragment<FragmentTeamsSearchBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_teams_search

    override val viewModel: TeamsSearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchRecyclerView.adapter = TeamsAdapter()
        handleNavigation()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: SearchEvents) {
        val action = (event as SearchEvents.TeamClickEvent).let {
            TeamsSearchFragmentDirections.actionTeamsSearchFragmentToTeamFragment(event.teamId)
        }
        findNavController().navigate(action)
    }


}