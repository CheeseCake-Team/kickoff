package com.cheesecake.presentation.screens.home

sealed interface HomeEvents {
    data class MatchClickedEvent(val homeTeamId: Int, val awayTeamId: Int, val date: String) :
        HomeEvents

    data class LeagueClickEvent(val leagueId: Int, val season: Int) : HomeEvents
}