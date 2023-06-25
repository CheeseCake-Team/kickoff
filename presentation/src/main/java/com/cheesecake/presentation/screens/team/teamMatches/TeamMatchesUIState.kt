package com.cheesecake.presentation.screens.team.teamMatches

import com.cheesecake.domain.entity.Fixture

data class TeamMatchesUIState(
    val data: List<TeamMatchItemUIState> = emptyList(),
    val errorMessage: String = "",
    val isLoading: Boolean = true
)
