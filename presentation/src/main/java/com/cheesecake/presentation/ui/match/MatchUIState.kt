package com.cheesecake.presentation.ui.match

data class MatchUIState(
    val errorMessage: String = "error",
    val isLoading: Boolean = true,
    val matchState: String,
    val firstTeamName: String,
    val firstTeamLogoUrl: String,
    val firstTeamGoals: Int,
    val secondTeamName: String,
    val secondTeamLogoUrl: String,
    val secondTeamGoals: Int,
)