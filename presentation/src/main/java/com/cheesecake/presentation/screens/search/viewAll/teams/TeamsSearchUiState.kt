package com.cheesecake.presentation.screens.search.viewAll.teams

import com.cheesecake.presentation.screens.search.models.TeamSearchItemUiState

data class TeamsSearchUiState(
    val items: List<TeamSearchItemUiState> = emptyList(),
    val isResultEmpty: Boolean = false
)

