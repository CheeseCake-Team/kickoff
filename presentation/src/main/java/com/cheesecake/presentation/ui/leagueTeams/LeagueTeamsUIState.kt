package com.cheesecake.presentation.ui.leagueTeams

import com.cheesecake.presentation.models.TeamUIState

data class LeagueTeamsUIState(
    val isLoading: Boolean = true,
    val data: List<TeamUIState> = emptyList(),
    val isError: String = "Error"
)