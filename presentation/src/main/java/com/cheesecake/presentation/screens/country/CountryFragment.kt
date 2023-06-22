package com.cheesecake.presentation.screens.country

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.base.BaseFragmentsAdapter
import com.cheesecake.presentation.databinding.FragmentCountryBinding
import com.cheesecake.presentation.screens.country.countryTeams.CountryTeamsFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountryFragment : BaseFragment<FragmentCountryBinding>() {
    override val layoutIdFragment = R.layout.fragment_country
    override val viewModel: CountryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentsAdapter = BaseFragmentsAdapter(
            requireActivity(),
            listOf(
                CountryTeamsFragment()
            )
        )
        binding.countryViewPager.adapter = fragmentsAdapter

        TabLayoutMediator(binding.tabLayout, binding.countryViewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Teams"
                1 -> tab.text = "Leagues"
            }
        }.attach()
    }


}