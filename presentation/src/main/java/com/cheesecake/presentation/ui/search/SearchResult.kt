package com.cheesecake.presentation.ui.search

import com.cheesecake.presentation.ui.league.LeagueUIState
import com.cheesecake.presentation.models.TeamUIState

sealed class SearchResult {
    data class Team(
        val items: List<TeamUIState>,
    ) : SearchResult()

    data class League(
        val items: List<LeagueSearchUIState>,
    ) : SearchResult()

}
