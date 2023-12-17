package com.cheesecake.presentation.screens.home

data class MatchItemUiState(
    val matchState: String = "",
    val matchDate: String = "",
    val matchTime: String = "",
    val homeTeamName: String = "",
    val awayTeamName: String = "",
    val homeTeamGoals: String = "",
    val awayTeamGoals: String = "",
    val homeTeamImageUrl: String = "",
    val awayTeamImageUrl: String = "",
    val onMatchClicked: () -> Unit = {},
)