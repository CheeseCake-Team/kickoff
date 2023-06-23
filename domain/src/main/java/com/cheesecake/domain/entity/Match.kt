package com.cheesecake.domain.entity

data class Match (
    val fixtureId: Int,
    val homeTeamId: Int,
    val homeTeamName: String,
    val homeTeamLogoUrl: String,
    val homeTeamGoals: Int?,
    val awayTeamId: Int,
    val awayTeamName: String,
    val awayTeamLogoUrl: String,
    val awayTeamGoals: Int?,
    val matchState: String
)