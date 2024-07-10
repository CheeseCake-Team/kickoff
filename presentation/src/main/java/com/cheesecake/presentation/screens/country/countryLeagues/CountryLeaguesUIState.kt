package com.cheesecake.presentation.screens.country.countryLeagues

data class CountryLeaguesUIState(
    val leagues: List<CompetitionItemUiState> = emptyList(),
    val isLoading: Boolean = true,
    val errorMessage: String = ""
)