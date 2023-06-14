package com.cheesecake.domain.entity

data class Fixture(
    val id: Int,
    val homeTeamName: String,
    val homeTeamLogoUrl: String,
    val homeTeamGoals: String?,
    val awayTeamName: String,
    val awayTeamLogoUrl: String,
    val awayTeamGoals: String?,
    val matchTime: String?,
    val matchDate: String,
    val isFinished: Boolean = false
)
