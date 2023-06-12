package com.cheesecake.ui.ui.teamstatistics

import com.cheesecake.domain.entity.Team

data class TeamStatisticsUIState(
    val isLoading: Boolean = true,
    val data: List<Team> = emptyList(),
    val isError: String = "Error"
)