package com.cheesecake.presentation.screens.country.countryteams

import com.cheesecake.presentation.base.ErrorUiState
import com.cheesecake.presentation.models.TeamUIState

data class CountyTeamsUiState(
    val teams: List<TeamUIState> = emptyList(),
    val isLoading: Boolean = true,
    val errorUiState: ErrorUiState? = null
)