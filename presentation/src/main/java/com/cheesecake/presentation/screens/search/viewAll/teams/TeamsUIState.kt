package com.cheesecake.presentation.screens.search.viewAll.teams

import com.cheesecake.presentation.screens.search.models.TeamSearchUIState

data class TeamsUIState(
    val isLoading: Boolean = false,
    val items: List<TeamSearchUIState> = emptyList(),
    val error: String = "",
    val isResultEmpty: Boolean = false
)

