package com.cheesecake.presentation.screens.home

sealed interface HomeEvents {
    object MatchClickedEvent : HomeEvents
    data class LeagueClickEvent(val leagueId: Int, val season: Int) : HomeEvents
}