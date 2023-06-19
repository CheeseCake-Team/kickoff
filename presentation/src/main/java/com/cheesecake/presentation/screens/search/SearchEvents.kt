package com.cheesecake.presentation.screens.search

sealed interface SearchEvents{
    data class LeagueClickEvent(val leagueId: Int, val season: Int) : SearchEvents
    data class ViewAllLClickEvent(val searchInput: String) : SearchEvents
    object TeamClickEvent : SearchEvents

}