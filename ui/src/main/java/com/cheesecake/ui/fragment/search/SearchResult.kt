package com.cheesecake.ui.fragment.search

import com.cheesecake.domain.entity.LeagueEntity
import com.cheesecake.domain.entity.TeamEntity

sealed class SearchResult {
    data class Team(val items: List<TeamEntity>): SearchResult()
    data class League(val items: List<LeagueEntity>): SearchResult()

}
