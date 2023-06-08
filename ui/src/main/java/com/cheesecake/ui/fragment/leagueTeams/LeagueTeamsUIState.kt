package com.cheesecake.ui.fragment.leagueTeams

data class LeagueTeamsUIState(
    val isLoading: Boolean = true,
    val data: List<TeamUIState> = emptyList(),
    val isError: String = "Error"
)