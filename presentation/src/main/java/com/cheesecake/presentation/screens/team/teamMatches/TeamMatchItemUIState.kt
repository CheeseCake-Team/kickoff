package com.cheesecake.presentation.screens.team.teamMatches

import com.cheesecake.presentation.screens.home.MatchItemUiState

data class TeamMatchItemUIState(
    val matchItemUIState: MatchItemUiState,
    val leagueName: String,
    val leagueImageUrl: String,
    val onClick  : () -> Unit = { }
)