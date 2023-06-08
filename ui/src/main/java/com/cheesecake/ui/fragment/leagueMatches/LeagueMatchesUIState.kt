package com.cheesecake.ui.fragment.leagueMatches

import com.cheesecake.domain.entity.FixtureEntity

data class LeagueMatchesUIState(
    val data: List<Pair<String, List<FixtureEntity>>> = emptyList(),
    val errorMessage: String = "",
    val isLoading: Boolean = true
)
