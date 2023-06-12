package com.cheesecake.ui.ui.search

import com.cheesecake.ui.ui.league.LeagueUIState
import com.cheesecake.ui.models.TeamUIState

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
