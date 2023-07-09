package com.cheesecake.presentation.screens.search.viewAll.leagues

import com.cheesecake.presentation.screens.search.models.LeagueSearchUIState

data class LeaguesUIState(
    val isLoading: Boolean = false,
    val items: List<LeagueSearchUIState> = emptyList(),
    val error: String = "",
    val isResultEmpty: Boolean = false
)

