package com.cheesecake.ui.ui.leagueTeams

import com.cheesecake.ui.models.TeamUIState

data class LeagueTeamsUIState(
    val isLoading: Boolean = true,
    val data: List<TeamUIState> = emptyList(),
    val isError: String = "Error"
)