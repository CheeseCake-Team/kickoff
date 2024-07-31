package com.cheesecake.presentation.screens.country

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.base.BaseFragmentsAdapter
import com.cheesecake.presentation.databinding.FragmentCountryBinding
import com.cheesecake.presentation.screens.country.countryLeagues.CountryLeaguesFragment
import com.cheesecake.presentation.screens.country.countryTeams.CountryTeamsFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountryFragment : BaseFragment<FragmentCountryBinding>() {
    override val layoutIdFragment = R.layout.fragment_country
    override val viewModel: CountryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeStatusBarColor()
        handleNavigation()
        init()
    }

    private fun init() {
        val fragmentsAdapter = BaseFragmentsAdapter(
            childFragmentManager,
            requireActivity().lifecycle, listOf(
                CountryTeamsFragment.newInstance(viewModel.countryNavigationArgs.countryName),
                CountryLeaguesFragment.newInstance(viewModel.countryNavigationArgs.countryName)
            )
        )
        binding.countryViewPager.adapter = fragmentsAdapter

        TabLayoutMediator(binding.tabLayout, binding.countryViewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Teams"
                1 -> tab.text = "Championship"
            }
        }.attach()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: CountryEvents) {
        when (event) {
            is CountryEvents.NavigateBack -> {
                findNavController().navigateUp()
            }
        }
    }
}