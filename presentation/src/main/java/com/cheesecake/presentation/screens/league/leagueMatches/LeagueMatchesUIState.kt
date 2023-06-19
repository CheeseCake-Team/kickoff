package com.cheesecake.presentation.screens.league.leagueMatches

import com.cheesecake.domain.entity.Fixture
import java.util.Date

data class LeagueMatchesUIState(
    val data: List<Pair<Date, List<Fixture>>> = emptyList(),
    val errorMessage: String = "",
    val isLoading: Boolean = true
)
