package com.cheesecake.domain.entity

import java.util.Date

data class Fixture(
    val id: Int,
    val matchId:String,
    val leagueName: String,
    val homeTeamName: String,
    val homeTeamLogoUrl: String,
    val homeTeamGoals: String?,
    val awayTeamName: String,
    val awayTeamLogoUrl: String,
    val awayTeamGoals: String?,
    val matchTime: String?,
    val matchDate: Date,
    val isFinished: Boolean = false,
    val leagueSeason: Int,
    val leagueLogoUrl: String,

)
