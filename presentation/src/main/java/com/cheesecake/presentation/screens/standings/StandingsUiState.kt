package com.cheesecake.presentation.screens.standings

data class StandingsUiState(
    val isLoading: Boolean = true,
    val errorMessage: String = "Error",
    val data: List<TeamStandingItemUiState> = emptyList(),
)