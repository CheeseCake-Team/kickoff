package com.cheesecake.presentation.screens.home

data class MatchItemUIState(
    val leagueId: Int = 0,
    val leagueSeason: Int = 0,
    val matchId: String = "",
    val timeZone: String = "",
    val matchState: String = "",
    val matchDate: String = "",
    val matchTime: String = "",
    val homeTeamName: String = "",
    val awayTeamName: String = "",
    val homeTeamGoals: Int = 0,
    val awayTeamGoals: Int = 0,
    val homeTeamImageUrl: String = "",
    val awayTeamImageUrl: String = "",
    val onclick: (matchId: String, season: Int, date: String) -> Unit = { _, _, _ ->},
)