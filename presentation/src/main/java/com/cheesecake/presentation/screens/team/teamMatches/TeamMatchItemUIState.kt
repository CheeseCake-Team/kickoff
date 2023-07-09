package com.cheesecake.presentation.screens.team.teamMatches

import com.cheesecake.presentation.screens.home.MatchItemUIState

data class TeamMatchItemUIState(
    val matchItemUIState: MatchItemUIState,
    val leagueName: String,
    val leagueImageUrl: String,
    val onClick  : () -> Unit = { }
)