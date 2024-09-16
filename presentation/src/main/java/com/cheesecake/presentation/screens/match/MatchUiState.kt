package com.cheesecake.presentation.screens.match

data class MatchUiState(
    val matchState: String = "",
    val homeTeamName: String = "",
    val homeTeamLogoUrl: String = "",
    val homeTeamGoals: String = "",
    val awayTeamName: String = "",
    val awayTeamLogoUrl: String = "",
    val awayTeamGoals: String = "",
    val onBackClick: () -> Unit = {},
    val noData: Boolean = false
)