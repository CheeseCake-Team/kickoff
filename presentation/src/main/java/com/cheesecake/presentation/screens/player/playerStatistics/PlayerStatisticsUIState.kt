package com.cheesecake.presentation.screens.player.playerStatistics

data class PlayerStatisticsUIState(
    val data: List<PlayerSectionItemUiState> = emptyList(),
    val isLoading : Boolean = true,
    val errorMessage: String = ""
)