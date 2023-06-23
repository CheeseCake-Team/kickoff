package com.cheesecake.presentation.screens.team

data class TeamUIState(
    val teamId: Int = 0,
    val errorMessage: String = "error",
    val isLoading: Boolean = true,
    val imageUrl: String = "",
    val teamName: String = "",
    val country: String = "",
    val isFavourite: Boolean = false,
    val onBackClick: () -> Unit = {},
    val onTeamFavoriteClick: (Int)-> Unit = {i-> }
)