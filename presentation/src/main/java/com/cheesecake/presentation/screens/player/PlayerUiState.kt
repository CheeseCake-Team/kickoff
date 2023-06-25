package com.cheesecake.presentation.screens.player

data class PlayerUiState(
    val playerName: String = "",
    val playerImageUrl: String = "",
    val onBackClick: () -> Unit = {},
    val isLoading: Boolean = true,
    val errorMessage: String = ""
)
