package com.cheesecake.presentation.screens.country.countryTeams

import com.cheesecake.presentation.models.TeamUIState

data class CountyTeamsUIState(
    val teams: List<TeamUIState> = emptyList(),
    val isLoading: Boolean = true,
    val errorMessage: String = ""
)