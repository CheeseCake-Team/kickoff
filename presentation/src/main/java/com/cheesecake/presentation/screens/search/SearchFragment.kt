package com.cheesecake.presentation.screens.search

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentSearchBinding
import com.cheesecake.presentation.screens.search.adapters.SearchAdapter
import com.cheesecake.presentation.screens.search.models.SearchType
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override val layoutIdFragment = R.layout.fragment_search
    override val viewModel: SearchViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupStatusBar()
        setSearchFocus()
        handleNavigation()
        binding.recyclerViewSearch.adapter = SearchAdapter()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: SearchEvents) {
        when (event) {
            is SearchEvents.LeagueClickEvent -> {
                findNavController().navigate(
                    SearchFragmentDirections.actionSearchFragmentToLeagueFragment(
                        event.leagueId, event.season
                    )
                )
            }

            is SearchEvents.ViewAllLClickEvent -> {
                findNavController().navigate(
                    SearchFragmentDirections.actionSearchFragmentToLeaguesSearchFragment(
                        viewModel.state.value.searchQuery
                    )
                )
            }

            is SearchEvents.BackClickEvent -> {
                findNavController().navigateUp()
            }

            else -> {
                throw (Throwable())
            }
        }
    }

    private fun setupStatusBar() {
        val statusBarColor = ContextCompat.getColor(requireContext(), R.color.cardSurface)
        requireActivity().window.statusBarColor = statusBarColor
    }

    override fun onResume() {
        super.onResume()
        requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav_bar).visibility =
            View.GONE
    }

    override fun onPause() {
        super.onPause()
        requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav_bar).visibility =
            View.VISIBLE
    }

    private fun setSearchFocus() {
        val searchEditText = binding.editTextSearch
        searchEditText.requestFocus()
        val inputManager =
            requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.showSoftInput(searchEditText, InputMethodManager.SHOW_IMPLICIT)
    }

}













