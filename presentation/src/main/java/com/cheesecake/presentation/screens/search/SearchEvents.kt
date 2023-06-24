package com.cheesecake.presentation.screens.search

import com.cheesecake.presentation.screens.search.models.SearchType

sealed interface SearchEvents{
    data class LeagueClickEvent(val leagueId: Int, val season: Int) : SearchEvents
    data class ViewAllLClickEvent(val searchInput: String, val type: SearchType) : SearchEvents
    data class TeamClickEvent(val teamId: Int, val season: Int) : SearchEvents
    object BackClickEvent: SearchEvents

}