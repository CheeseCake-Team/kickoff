package com.cheesecake.presentation.screens.favLeaguesSelection

data class FavLeagueItemUIState(
    val imageUrl: String = "",
    val leagueName: String = "",
    val isSelected: Boolean = false,
    val onFavorite: () -> Unit,
)