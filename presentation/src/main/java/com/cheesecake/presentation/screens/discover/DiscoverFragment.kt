package com.cheesecake.presentation.screens.discover

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentDiscoverBinding
import com.cheesecake.presentation.screens.country.CountryFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiscoverFragment : BaseFragment<FragmentDiscoverBinding>() {
    override val layoutIdFragment = R.layout.fragment_discover
    override val viewModel: DiscoverViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeStatusBarColor(R.color.cardSurface)
        handleNavigation()
        binding.recyclerViewTeamCountry.adapter = DiscoverCountryAdapter()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: DiscoverTeamCountryEvents) {
        when (event) {
            is DiscoverTeamCountryEvents.NavigateToCountry ->
                findNavController().navigate(
                    DiscoverFragmentDirections.actionDiscoverFragmentToCountryFragment(event.CountryName)
                )
        }
    }

}