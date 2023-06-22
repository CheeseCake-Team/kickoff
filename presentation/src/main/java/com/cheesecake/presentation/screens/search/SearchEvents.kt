package com.cheesecake.presentation.screens.search

sealed interface SearchEvents{
    data class LeagueClickEvent(val leagueId: Int, val season: Int) : SearchEvents
    data class ViewAllLClickEvent(val searchInput: String) : SearchEvents
    data class TeamClickEvent(val teamId: Int, val season: Int) : SearchEvents
    object BackClickEvent: SearchEvents

}