package com.cheesecake.presentation.screens.search

import com.cheesecake.presentation.screens.league.LeagueUIState
import com.cheesecake.presentation.models.TeamUIState

sealed class SearchResult {
    data class Team(
        val items: List<TeamUIState>,
        val isSelected: Boolean
    ) : SearchResult()

    data class League(
        val items: List<LeagueUIState>,
        val isSelected: Boolean
    ) : SearchResult()

}
