package com.cheesecake.presentation.screens.search.models

sealed class SearchResult(val list: List<Any>) {
    data class Team(
        val onViewAllClick: (SearchType) -> Unit,
        val items: List<TeamSearchItemUiState>,
        val itemsSize: Int,
        val type: SearchType = SearchType.TEAM,
    ) : SearchResult(items)

    data class Competition(
        val onViewAllClick: (SearchType) -> Unit,
        val items: List<CompetitionSearchUiState>,
        val itemsSize: Int,
        val type: SearchType = SearchType.COMPETITION,
    ) : SearchResult(items)

}
