package com.cheesecake.presentation.screens.team.teamMatches

import com.cheesecake.presentation.screens.home.MatchItemUiState

data class TeamMatchItemUiState(
    val matchItemUiState: MatchItemUiState,
    val competitionName: String,
    val competitionImageUrl: String,
    val onCompetitionClicked : () -> Unit = { }
)