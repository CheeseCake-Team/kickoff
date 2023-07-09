package com.cheesecake.presentation.screens.league.leagueMatches

sealed interface LeagueMatchesEvent {

    data class MatchClickedEvent(val homeTeamId: Int, val awayTeamId: Int, val date: String) :
        LeagueMatchesEvent
}