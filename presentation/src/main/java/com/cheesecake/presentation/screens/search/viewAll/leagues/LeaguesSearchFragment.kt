package com.cheesecake.presentation.screens.search.viewAll.leagues

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentLeaguesSearchBinding
import com.cheesecake.presentation.screens.search.SearchEvents
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LeaguesSearchFragment : BaseFragment<FragmentLeaguesSearchBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_leagues_search

    override val viewModel: LeaguesSearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchRecyclerView.adapter = LeaguesAdapter()
        handleNavigation()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: SearchEvents) {
        val action = (event as SearchEvents.LeagueClickEvent).let {
            LeaguesSearchFragmentDirections.actionLeaguesSearchFragmentToLeagueFragment(
                event.leagueId
            )
        }
        findNavController().navigate(action)
    }


}