package com.cheesecake.presentation.screens.search.models

import com.cheesecake.presentation.models.TeamUIState

sealed class SearchResult(val list: List<Any>) {
    data class Team(
        val onViewAllClick: (SearchType) -> Unit,
        val items: List<TeamSearchUIState>,
        val itemsSize: Int,
        val type: SearchType = SearchType.TEAM,
    ) : SearchResult(items)

    data class League(
        val onViewAllClick: (SearchType) -> Unit,
        val items: List<LeagueSearchUIState>,
        val itemsSize: Int,
        val type: SearchType = SearchType.LEAGUE,
    ) : SearchResult(items)

}
