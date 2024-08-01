package com.cheesecake.presentation.screens.country.countrycompetitions

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentCountryCompetitionsBinding
import com.cheesecake.presentation.screens.country.CountryFragmentDirections
import com.cheesecake.presentation.screens.country.countryteams.CountryTeamsArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountryCompetitionsFragment : BaseFragment<FragmentCountryCompetitionsBinding>() {
    override val layoutIdFragment = R.layout.fragment_country_competitions
    override val viewModel: CountryCompetitionsViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
        binding.leagueRecyclerView.adapter = CountryCompetitionsAdapter()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: CountryCompetitionsNavigationEvent) {
        when (event) {
            is CountryCompetitionsNavigationEvent.NavigateToCompetition -> {
                findNavController()
                    .navigate(
                        CountryFragmentDirections.actionCountryFragmentToLeagueFragment(
                            event.competitionId
                        )
                    )
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(countryName: String) =
            CountryCompetitionsFragment().apply {
                arguments = Bundle().apply {
                    putString(CountryTeamsArgs.COUNTRY_NAME_ARGS, countryName)
                }
            }
    }
}