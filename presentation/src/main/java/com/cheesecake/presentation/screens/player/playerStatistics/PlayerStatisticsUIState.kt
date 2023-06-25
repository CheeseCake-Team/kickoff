package com.cheesecake.presentation.screens.player.playerStatistics

data class PlayerStatisticsUIState(
    val data: List<PlayerSectionItemUIState> = emptyList(),
    val isLoading : Boolean = true,
    val errorMessage: String = ""
)