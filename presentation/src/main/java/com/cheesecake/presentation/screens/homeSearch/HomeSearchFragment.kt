package com.cheesecake.presentation.screens.homeSearch

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.cheesecake.domain.entity.RecentSearchType
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentSearchHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeSearchFragment : BaseFragment<FragmentSearchHomeBinding>() {
    override val layoutIdFragment = R.layout.fragment_search_home
    override val viewModel: HomeSearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: HomeSearchEvent?) {
        val action = when (event) {
            is HomeSearchEvent.RecentClickSearchEvent -> {
                getRecentSearchActionByType(event)
            }

            is HomeSearchEvent.PlayerClickSearchEvent -> {
                throw Throwable("")
            }

            else -> {
                throw Throwable("")
            }
        }
        findNavController().navigate(action)
    }

    private fun getRecentSearchActionByType(event: HomeSearchEvent.RecentClickSearchEvent): NavDirections {
        return when (event.recent.type) {
            RecentSearchType.TEAM -> {
                throw Throwable("")
            }

            RecentSearchType.LEAGUE -> {
                HomeSearchFragmentDirections.actionHomeSearchFragmentToLeagueFragment(
                    event.recent.id, event.recent.id
                )
            }
        }
    }


}