package com.cheesecake.domain.entity

import java.util.Date

data class Fixture(
    val id: Int,
    val leagueName: String,
    val homeTeamName: String,
    val homeTeamLogoUrl: String,
    val homeTeamGoals: String?,
    val homeTeamID: Int,
    val awayTeamName: String,
    val awayTeamLogoUrl: String,
    val awayTeamGoals: String?,
    val awayTeamID: Int,
    val matchDate: Date,
    val leagueSeason: Int,
    val leagueLogoUrl: String,
    val matchState: String
)
