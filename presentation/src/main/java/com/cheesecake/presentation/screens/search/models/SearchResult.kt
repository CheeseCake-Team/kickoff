package com.cheesecake.presentation.screens.search.models

import com.cheesecake.presentation.models.TeamUIState

sealed class SearchResult {
    data class Team(
        var items: List<TeamUIState>,
    ) : SearchResult()

    data class League(
        val onViewAllClick: () -> Unit,
        var items: List<LeagueSearchUIState>,
    ) : SearchResult()

}
