package com.cheesecake.presentation.screens.competition.competitionteams

import com.cheesecake.presentation.models.TeamUIState

data class CompetitionTeamsUiState(
    val teams: List<TeamUIState> = emptyList(),
)