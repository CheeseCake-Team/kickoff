package com.cheesecake.presentation.screens.standings

data class TeamStandingItemUiState(
    val form: List<String>,
    val rank: String,
    val name: String,
    val imageUrl: String,
    val played: String,
    val won: String,
    val draw: String,
    val lose: String,
    val points: String,
    val goalsForAgainst: String,
)