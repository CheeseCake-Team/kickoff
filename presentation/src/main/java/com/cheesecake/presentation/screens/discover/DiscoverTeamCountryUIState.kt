package com.cheesecake.presentation.screens.discover

import com.cheesecake.presentation.models.TeamCountryUIState


data class DiscoverTeamCountryUIState(
    val isLoading: Boolean = true,
    val data: List<TeamCountryUIState> = emptyList(),
    val isError: String = "Error"
)