package com.cheesecake.presentation.screens.country.countryteams

import com.cheesecake.presentation.models.TeamUIState

data class CountyTeamsUiState(
    val teams: List<TeamUIState> = emptyList(),
)