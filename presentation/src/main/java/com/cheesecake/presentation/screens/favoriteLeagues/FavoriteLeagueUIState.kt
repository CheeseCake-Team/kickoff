package com.cheesecake.presentation.screens.favoriteLeagues

data class FavoriteLeagueUIState(
    val id: Int = 0,
    val imageUrl: String = "",
    val leagueName: String = "",
    val leagueCountry: String = "",
    val onFavorite: () -> Unit,
    val isFavourite: Boolean = false
)
