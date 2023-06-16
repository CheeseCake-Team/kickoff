package com.cheesecake.presentation.screens.teamstatistics

import com.cheesecake.domain.entity.Team

data class TeamStatisticsUIState(
    val homePlayed: Int,
    val homeWins: Int,
    val homeLoses: Int,
    val homeCleanSheet: Int,
    val homeFailed: Int,
    val homeGoalsFor: Int,
    val homeGoalsAgainst: Int,

    val awayPlayed: Int,
    val awayWins: Int,
    val awayLoses: Int,
    val awayCleanSheet: Int,
    val awayFailed: Int,
    val awayGoalsFor: Int,
    val awayGoalsAgainst: Int,

    val totalPlayed: Int,
    val totalWins: Int,
    val totalLoses: Int,
    val totalCleanSheet: Int,
    val totalFailed: Int,
    val totalGoalsFor: Int,
    val totalGoalsAgainst: Int,

    val isLoading: Boolean = true,
    val data: List<Team> = emptyList(),
    val isError: String = "Error"
)