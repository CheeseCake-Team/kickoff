package com.cheesecake.presentation.ui.match.events

data class MatchEventUIState(
    val errorMessage: String = "error",
    val isLoading: Boolean = true,
)