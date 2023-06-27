package com.cheesecake.presentation.screens.topscorers

import com.cheesecake.domain.entity.PlayerStatistics

data class TopScorersUiState(
    val isLoading: Boolean = true,
    val errorMessage: String = "Error",
    val data: List<PlayerStatistics> = emptyList(),
    val onBackClick: () -> Unit = {}
)