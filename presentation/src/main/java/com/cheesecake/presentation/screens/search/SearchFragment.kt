package com.cheesecake.presentation.screens.search

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override val layoutIdFragment = R.layout.fragment_search
    override val viewModel: SearchViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupStatusBar()
        binding.searchRecyclerView.adapter = SearchAdapter()
        handleNavigation()

    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: SearchEvents) {
        val action = when (event) {
            is SearchEvents.LeagueClickEvent -> {
                SearchFragmentDirections.actionSearchFragmentToLeagueFragment(
                    event.leagueId, event.season
                )
            }

            is SearchEvents.ViewAllLClickEvent -> {
                SearchFragmentDirections.actionSearchFragmentToLeaguesSearchFragment(
                    viewModel.searchInput.value
                )
            }

            else -> {
                throw (Throwable())
            }
        }
        findNavController().navigate(action)
    }

    private fun setupStatusBar() {
        val statusBarColor = ContextCompat.getColor(requireContext(), R.color.cardSurface)
        requireActivity().window.statusBarColor = statusBarColor
    }


}













