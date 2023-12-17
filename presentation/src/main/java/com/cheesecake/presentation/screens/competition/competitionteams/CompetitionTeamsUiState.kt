package com.cheesecake.presentation.screens.competition.competitionteams

import com.cheesecake.presentation.models.TeamUIState

data class CompetitionTeamsUiState(
    val isLoading: Boolean = true,
    val data: List<TeamUIState> = emptyList(),
    val isError: String = "Error"
)