package com.cheesecake.presentation.screens.search.models

import com.cheesecake.presentation.models.TeamUIState

sealed class SearchResult(val list: List<Any>) {
    data class Team(
        var items: List<TeamUIState>,
        var itemsSize: Int
    ) : SearchResult(items)

    data class League(
        val onViewAllClick: () -> Unit,
        var items: List<LeagueSearchUIState>,
        var itemsSize: Int
    ) : SearchResult(items)

}
