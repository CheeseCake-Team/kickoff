package com.cheesecake.domain.entity

data class TeamStatisticsEntity(
    val home: TeamStats,
    val away: TeamStats,
    val total: TeamStats
)

data class TeamStats(
    val played: Int,
    val wins: Int,
    val draws: Int,
    val loses: Int,
    val cleanSheet: Int,
    val failedToScore: Int,
    val goalsFor: Int,
    val goalsAgainst: Int
)
