package com.cheesecake.presentation.screens.match.statistics

import com.cheesecake.domain.entity.StatisticsType

data class MatchStatisticsUIState(
    val statisticsItem: List<StatisticsItemUiState> = emptyList(),
    val errorMessage: String = "error",
    val isLoading: Boolean = true
)

data class StatisticsItemUiState(
    val homeTeamValue: Int,
    val awayTeamValue: Int,
    val typeValue: String,
    val statisticsType: StatisticsType,
    val homeTeamPercentage: Int,
    val awayTeamPercentage: Int
)