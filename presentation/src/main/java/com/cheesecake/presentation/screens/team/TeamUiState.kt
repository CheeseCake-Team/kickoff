package com.cheesecake.presentation.screens.team

data class TeamUiState(
    val errorMessage: String = "error",
    val isLoading: Boolean = true,
    val imageUrl: String = "",
    val teamName: String = "",
    val country: String = "",
    val isFavourite: Boolean = false
)