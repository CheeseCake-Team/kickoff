package com.cheesecake.presentation.screens.league.leagueDetails

sealed interface LeagueDetailsEvents {
    object OnStandingEvent:LeagueDetailsEvents
    object OnGoalsScoredEvent :LeagueDetailsEvents
    data class OnLeagueClickedEvent(val leagueId:Int):LeagueDetailsEvents
    data class OnPlayerClickedEvent(val playerId:Int):LeagueDetailsEvents
}