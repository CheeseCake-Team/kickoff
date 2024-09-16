package com.cheesecake.presentation.screens.match.statistics

import com.cheesecake.domain.entity.StatisticsType

data class MatchStatisticsUiState(
    val statisticsItem: List<StatisticsItemUiState> = emptyList(),
    val noData: Boolean = false
)

data class StatisticsItemUiState(
    val homeTeamValue: Int,
    val awayTeamValue: Int,
    val typeValue: String,
    val statisticsType: StatisticsType,
    val homeTeamPercentage: Int,
    val awayTeamPercentage: Int
)