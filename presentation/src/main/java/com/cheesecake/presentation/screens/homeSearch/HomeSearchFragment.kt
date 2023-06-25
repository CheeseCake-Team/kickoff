package com.cheesecake.presentation.screens.homeSearch

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.cheesecake.domain.entity.RecentSearchType
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentHomeSearchBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeSearchFragment : BaseFragment<FragmentHomeSearchBinding>() {
    override val layoutIdFragment = R.layout.fragment_home_search
    override val viewModel: HomeSearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupStatusBar()
        binding.recyclerViewHomeSearch.adapter = HomeSearchAdapter()
        handleNavigation()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: HomeSearchEvent?) {
        val action = when (event) {
            is HomeSearchEvent.RecentClickEvent -> {
                getRecentSearchActionByType(event)
            }

            is HomeSearchEvent.PlayerClickEvent -> {
                throw Throwable("")
            }

            is HomeSearchEvent.SearchBarClick -> {
                HomeSearchFragmentDirections.actionHomeSearchFragmentToSearchFragment()
            }

            else -> {
                throw Throwable("")
            }
        }
        findNavController().navigate(action)
    }

    private fun getRecentSearchActionByType(event: HomeSearchEvent.RecentClickEvent): NavDirections {
        return when (event.recent.type) {
            RecentSearchType.TEAM -> {
                throw Throwable("")
            }

            RecentSearchType.LEAGUE -> {
                HomeSearchFragmentDirections.actionHomeSearchFragmentToLeagueFragment(
                    event.recent.id, event.recent.id
                )
            }

            RecentSearchType.UNKNOWN -> {
                throw Throwable("")
            }
        }
    }

    private fun setupStatusBar() {
        val statusBarColor = ContextCompat.getColor(requireContext(), R.color.cardSurface)
        requireActivity().window.statusBarColor = statusBarColor
    }


}