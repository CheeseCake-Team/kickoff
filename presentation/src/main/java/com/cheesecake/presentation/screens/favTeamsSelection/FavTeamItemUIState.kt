package com.cheesecake.presentation.screens.favTeamsSelection

data class FavTeamItemUIState(
    val teamId : Int = 0,
    val teamName: String = "",
    val imageUrl: String = "",
    val isSelected: Boolean = false,
    val onFavorite: () -> Unit,
)