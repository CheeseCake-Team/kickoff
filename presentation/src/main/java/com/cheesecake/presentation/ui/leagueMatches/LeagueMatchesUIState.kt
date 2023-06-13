package com.cheesecake.presentation.ui.leagueMatches

import com.cheesecake.domain.entity.Fixture

data class LeagueMatchesUIState(
    val data: List<Pair<String, List<Fixture>>> = emptyList(),
    val errorMessage: String = "",
    val isLoading: Boolean = true
)
