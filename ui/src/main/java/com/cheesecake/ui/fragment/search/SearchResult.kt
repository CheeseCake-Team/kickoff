package com.cheesecake.ui.fragment.search

import com.cheesecake.ui.fragment.league.LeagueUIState
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
