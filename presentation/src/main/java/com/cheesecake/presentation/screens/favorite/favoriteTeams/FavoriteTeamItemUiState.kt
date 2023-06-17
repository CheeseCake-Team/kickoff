package com.cheesecake.presentation.screens.favorite.favoriteTeams

data class FavoriteTeamItemUiState(
    val teamId: Int,
    val name: String,
    val country: String,
    val imageUrl: String,
    val isFavorite: Boolean,
    val onFavoriteClick: (Int) -> Unit,
    val onFavoriteTeamClick: (teamId: Int) -> Unit
)