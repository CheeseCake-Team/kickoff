package com.cheesecake.presentation.screens.competition

data class CompetitionUiState(
    val competitionSeason: Int = 0,
    val errorMessage: String = "",
    val isLoading: Boolean = true,
    val seasonStartEndYear: String = "",
    val imageUrl: String = "",
    val competitionName: String = "",
    val isFavourite: Boolean = false,
)
