package com.cheesecake.presentation.screens.match

data class MatchUIState(
    val errorMessage: String = "error",
    val isLoading: Boolean = true,
    val matchId: String = "",
    val matchState: String = "",
    val homeTeamName: String = "",
    val homeTeamLogoUrl: String = "",
    val homeTeamGoals: Int? = 0,
    val awayTeamName: String = "",
    val awayTeamLogoUrl: String = "",
    val awayTeamGoals: Int? = 0
)