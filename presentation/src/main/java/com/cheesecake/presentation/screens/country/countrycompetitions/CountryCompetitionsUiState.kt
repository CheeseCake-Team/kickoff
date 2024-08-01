package com.cheesecake.presentation.screens.country.countrycompetitions

data class CountryCompetitionsUiState(
    val leagues: List<CompetitionItemUiState> = emptyList(),
    val isLoading: Boolean = true,
    val errorMessage: String = ""
)