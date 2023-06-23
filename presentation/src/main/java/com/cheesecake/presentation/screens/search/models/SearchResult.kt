package com.cheesecake.presentation.screens.search.models

import com.cheesecake.presentation.models.TeamUIState

sealed class SearchResult {
    data class Team(
        var items: List<TeamUIState>,
        var itemsSize: Int
    ) : SearchResult()

    data class League(
        val onViewAllClick: () -> Unit,
        var items: List<LeagueSearchUIState>,
        var itemsSize: Int
    ) : SearchResult()

}
