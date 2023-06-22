package com.cheesecake.presentation.screens.country.countryLeagues

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentCountryLeaguesBinding
import com.cheesecake.presentation.screens.country.countryTeams.CountryTeamsArgs
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CountryLeaguesFragment : BaseFragment<FragmentCountryLeaguesBinding>() {
    override val layoutIdFragment = R.layout.fragment_country_leagues
    override val viewModel: CountryLeaguesViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
        binding.leagueRecyclerView.adapter = CountryLeaguesAdapter()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: CountryLeaguesNavigationEvent) {
        when (event) {
            is CountryLeaguesNavigationEvent.NavigateToLeague -> {
                TODO("You should Navigate here and you have the id and season")
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(countryName: String) =
            CountryLeaguesFragment().apply {
                arguments = Bundle().apply {
                    putString(CountryTeamsArgs.COUNTRY_NAME_ARGS, countryName)
                }
            }
    }

}