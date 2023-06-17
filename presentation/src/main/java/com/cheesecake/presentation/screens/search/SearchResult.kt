package com.cheesecake.presentation.screens.search

import com.cheesecake.presentation.models.TeamUIState

sealed class SearchResult {
    data class Team(
        var items: List<TeamUIState>,
    ) : SearchResult()

    data class League(
        var items: List<LeagueSearchUIState>,
    ) : SearchResult()

}
