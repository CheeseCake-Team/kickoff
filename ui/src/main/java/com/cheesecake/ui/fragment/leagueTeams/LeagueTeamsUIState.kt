package com.cheesecake.ui.fragment.leagueTeams

import com.cheesecake.domain.entity.TeamEntity

data class LeagueTeamsUIState(
    val isLoading: Boolean = true,
    val data: List<TeamEntity> = emptyList(),
    val isError: String = "Error"
)