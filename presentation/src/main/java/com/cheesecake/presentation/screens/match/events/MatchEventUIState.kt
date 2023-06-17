package com.cheesecake.presentation.screens.match.events

data class MatchEventUIState(
    val errorMessage: String = "error",
    val isLoading: Boolean = true,
)