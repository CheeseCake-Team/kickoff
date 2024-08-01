package com.cheesecake.presentation.screens.country.countrycompetitions

data class CountryCompetitionsUiState(
    val competitions: List<CompetitionItemUiState> = emptyList(),
)