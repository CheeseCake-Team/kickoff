package com.cheesecake.domain.entity
data class TeamStatisticsEntity(
    val played: ScoreStats,
    val wins: ScoreStats,
    val draws: ScoreStats,
    val loses: ScoreStats,
    val cleanSheet: ScoreStats,
    val failedToScore: ScoreStats,
    val goalsFor: ScoreStats,
    val goalsAgainst: ScoreStats
)

data class ScoreStats(
    val home: Int,
    val away: Int,
    val total: Int
)