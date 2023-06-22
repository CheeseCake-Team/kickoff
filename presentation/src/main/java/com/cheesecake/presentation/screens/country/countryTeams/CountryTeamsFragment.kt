package com.cheesecake.presentation.screens.country.countryTeams

import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentCountryTeamsBinding

class CountryTeamsFragment : BaseFragment<FragmentCountryTeamsBinding>() {
    override val layoutIdFragment = R.layout.fragment_country_teams
    override val viewModel: CountryTeamsViewModel by viewModels()

}