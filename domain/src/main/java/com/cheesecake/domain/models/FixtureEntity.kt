package com.cheesecake.domain.models

data class FixtureEntity(
    val homeTeamName: String,
    val homeTeamLogo: String,
    val homeTeamGoals: Int?,
    val awayTeamName: String,
    val awayTeamLogo: String,
    val awayTeamGoals: Int?,
    val matchTime: Int?,
    val isFinished: Boolean = false
)
