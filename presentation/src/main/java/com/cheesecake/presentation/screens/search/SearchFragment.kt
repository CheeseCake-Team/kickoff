package com.cheesecake.presentation.screens.search

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentSearchBinding
import com.cheesecake.presentation.screens.search.adapters.SearchAdapter
import com.cheesecake.presentation.screens.search.models.SearchType
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override val layoutIdFragment = R.layout.fragment_search
    override val viewModel: SearchViewModel by viewModels()

    override fun onResume() {
        super.onResume()
        changeStatusBarColor()
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        binding.recyclerViewSearch.adapter = SearchAdapter()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: SearchEvents) {
        when (event) {
            is SearchEvents.CompetitionClickEvent -> {
                findNavController().navigate(
                    SearchFragmentDirections.actionSearchFragmentToLeagueFragment(
                        event.competitionId
                    )
                )
            }

            is SearchEvents.ViewAllLClickEvent -> {
                findNavController().navigate(getRecentSearchActionByType(event))
            }

            is SearchEvents.TeamClickEvent -> {
                findNavController().navigate(
                    SearchFragmentDirections.actionSearchFragmentToTeamFragment(
                        event.teamId
                    )
                )
            }

            is SearchEvents.BackClickEvent -> {
                findNavController().navigateUp()
            }
        }
    }

    private fun getRecentSearchActionByType(event: SearchEvents.ViewAllLClickEvent): NavDirections {
        return when (event.type) {
            SearchType.COMPETITION -> {
                SearchFragmentDirections.actionSearchFragmentToLeaguesSearchFragment(
                    viewModel.state.value.searchQuery
                )
            }

            SearchType.TEAM -> {
                SearchFragmentDirections.actionSearchFragmentToTeamsSearchFragment(
                    viewModel.state.value.searchQuery
                )
            }
        }
    }

    private fun init() {
        setSearchFocus()
        handleNavigation()
        handleOnError()
    }

    private fun handleOnError() {
        lifecycleScope.launch {
            viewModel.state.collect {
                handleOnError(it.error)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onPause() {
        super.onPause()
        resetStatusBarColor()
    }

    private fun setSearchFocus() {
        val searchEditText = binding.editTextSearch
        searchEditText.requestFocus()
        val inputManager =
            requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.showSoftInput(searchEditText, InputMethodManager.SHOW_IMPLICIT)
    }
}













