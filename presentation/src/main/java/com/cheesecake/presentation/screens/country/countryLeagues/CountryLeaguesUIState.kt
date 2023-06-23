package com.cheesecake.presentation.screens.country.countryLeagues

import com.cheesecake.presentation.screens.league.LeagueItemUIState

data class CountryLeaguesUIState(
    val leagues: List<LeagueItemUIState> = emptyList(),
    val isLoading: Boolean = true,
    val errorMessage: String = ""
)