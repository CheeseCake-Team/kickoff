package com.cheesecake.presentation.screens.country.countryTeams

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.screens.country.countryTeams.CountryTeamsArgs.Companion.COUNTRY_NAME_ARGS
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentCountryTeamsBinding
import com.cheesecake.presentation.screens.country.CountryFragmentDirections
import com.cheesecake.presentation.screens.league.leagueTeams.TeamsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountryTeamsFragment : BaseFragment<FragmentCountryTeamsBinding>() {
    override val layoutIdFragment = R.layout.fragment_country_teams
    override val viewModel: CountryTeamsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
        binding.teamsRecyclerView.adapter = TeamsAdapter()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: CountryTeamsNavigationEvent) {
        when (event) {
            is CountryTeamsNavigationEvent.NavigateToTeam -> {
                findNavController().navigate(
                    CountryFragmentDirections.actionCountryFragmentToLeagueFragment(event.teamId, 2022)
                )
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(countryName: String) =
            CountryTeamsFragment().apply {
                arguments = Bundle().apply {
                    putString(COUNTRY_NAME_ARGS, countryName)
                }
            }
    }

}