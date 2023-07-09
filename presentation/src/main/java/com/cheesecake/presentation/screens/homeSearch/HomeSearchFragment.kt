package com.cheesecake.presentation.screens.homeSearch

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
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
        changeStatusBarColor()
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
                HomeSearchFragmentDirections.actionHomeSearchFragmentToTeamFragment(
                    event.recent.id
                )
            }

            RecentSearchType.LEAGUE -> {
                HomeSearchFragmentDirections.actionHomeSearchFragmentToLeagueFragment(
                    event.recent.id
                )
            }

            RecentSearchType.UNKNOWN -> {
                throw Throwable("")
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onPause() {
        super.onPause()
        resetStatusBarColor()
    }


}