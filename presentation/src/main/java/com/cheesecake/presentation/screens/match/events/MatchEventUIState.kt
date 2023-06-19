package com.cheesecake.presentation.screens.match.events

data class MatchEventUIState(
    val errorMessage: String = "error",
    val isLoading: Boolean = true,
    val time: Int? = 0,
    val teamId: Int= 0,
    val playerId: Int = 0,
    val playerName: String = "",
    val SubstituentPlayerId: String? = "",
    val SubstituentPlayerName: String?= "",
    val type: String = "",
    val detail: String? = ""
)