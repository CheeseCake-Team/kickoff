package com.cheesecake.presentation.screens.home

data class DateMatchItemUIState(
    val leagueId: Int,
    val leagueSeason: Int,
    val timeZone: String,
    val matchState: String,
    val matchTime: String,
    val homeTeamName: String,
    val awayTeamName: String,
    val homeTeamGoals: Int,
    val awayTeamGoals: Int
)