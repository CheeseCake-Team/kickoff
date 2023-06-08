package com.cheesecake.domain.entity

data class FixtureEntity(
    val homeTeamName: String,
    val homeTeamLogo: String,
    val homeTeamGoals: String?,
    val awayTeamName: String,
    val awayTeamLogo: String,
    val awayTeamGoals: String?,
    val matchTime: Int?,
    val matchDate: String,
    val isFinished: Boolean = false
)
