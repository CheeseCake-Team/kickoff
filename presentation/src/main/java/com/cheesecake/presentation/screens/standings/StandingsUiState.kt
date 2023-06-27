package com.cheesecake.presentation.screens.standings

import com.cheesecake.domain.entity.TeamStanding

data class StandingsUiState(
    val isLoading: Boolean = true,
    val errorMessage: String = "Error",
    val data: List<TeamStandingItemUIState> = emptyList(),
    val onBackClick: () -> Unit = {}
)