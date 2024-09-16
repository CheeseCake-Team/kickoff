package com.cheesecake.presentation.screens.search.viewAll.competitions

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentCompetitionsSearchBinding
import com.cheesecake.presentation.screens.search.SearchEvents
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CompetitionsSearchFragment : BaseFragment<FragmentCompetitionsSearchBinding>() {
    override val layoutIdFragment: Int = R.layout.fragment_competitions_search
    override val viewModel: CompetitionsSearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchRecyclerView.adapter = CompetitionsSearchAdapter()
        handleNavigation()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: SearchEvents) {
        val action = (event as SearchEvents.CompetitionClickEvent).let {
            CompetitionsSearchFragmentDirections.actionLeaguesSearchFragmentToLeagueFragment(
                event.competitionId
            )
        }
        findNavController().navigate(action)
    }
}