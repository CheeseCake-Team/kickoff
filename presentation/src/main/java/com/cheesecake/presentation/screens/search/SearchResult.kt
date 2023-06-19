package com.cheesecake.presentation.screens.search

sealed class SearchResult {
    data class Team(
        var items: List<TeamSearchUIState>,
    ) : SearchResult()

    data class League(
        val onViewAllClick: () -> Unit,
        var items: List<LeagueSearchUIState>,
    ) : SearchResult()

}
