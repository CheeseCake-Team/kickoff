package com.cheesecake.presentation.screens.player

data class PlayerUiState(
    val playerName: String = "",
    val playerImageUrl: String = "",
    val teamName: String = "",
    val teamCountry: String = "",
    val isLoading: Boolean = true,
    val errorMessage: String = ""
)