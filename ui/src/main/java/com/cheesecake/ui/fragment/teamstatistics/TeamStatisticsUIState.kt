package com.cheesecake.ui.fragment.teamstatistics

import com.cheesecake.domain.entity.TeamEntity

data class TeamStatisticsUIState(
    val isLoading: Boolean = true,
    val data: List<TeamEntity> = emptyList(),
    val isError: String = "Error"
)