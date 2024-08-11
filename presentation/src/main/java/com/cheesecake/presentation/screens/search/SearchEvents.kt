package com.cheesecake.presentation.screens.search

import com.cheesecake.presentation.screens.search.models.SearchType

sealed interface SearchEvents{
    data class CompetitionClickEvent(val competitionId: Int) : SearchEvents
    data class ViewAllLClickEvent(val searchInput: String, val type: SearchType) : SearchEvents
    data class TeamClickEvent(val teamId: Int) : SearchEvents
    object BackClickEvent: SearchEvents

}