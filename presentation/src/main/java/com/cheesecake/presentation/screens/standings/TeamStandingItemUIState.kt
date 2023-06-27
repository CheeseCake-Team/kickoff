package com.cheesecake.presentation.screens.standings

data class TeamStandingItemUIState(
    val form: List<String>,
    val rank: String,
    val name: String,
    val logo: String,
    val played: String,
    val won: String,
    val draw: String,
    val lose: String,
    val points: String,
    val goalsForAgainst: String,
)
