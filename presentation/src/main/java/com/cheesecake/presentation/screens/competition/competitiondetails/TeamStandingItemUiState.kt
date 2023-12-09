package com.cheesecake.presentation.screens.competition.competitiondetails

data class TeamStandingItemUiState(
    val imageUrl: String,
    val name: String,
    val played: String,
    val won: String,
    val lose: String,
    val draw: String,
    val points: String
)