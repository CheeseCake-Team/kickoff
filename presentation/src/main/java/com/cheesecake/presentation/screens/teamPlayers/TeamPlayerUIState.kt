package com.cheesecake.presentation.screens.teamPlayers

import com.cheesecake.domain.entity.PlayerStatistics


data class TeamPlayerUIState(
    val data: List<Pair<String, List<PlayerStatistics>>> = emptyList(),
    val errorMessage: String = "",
    val isLoading: Boolean = true
)