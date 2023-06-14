package com.cheesecake.presentation.screens.teamstatistics

import com.cheesecake.domain.entity.Team

data class TeamStatisticsUIState(
    val isLoading: Boolean = true,
    val data: List<Team> = emptyList(),
    val isError: String = "Error"
)