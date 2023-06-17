package com.cheesecake.presentation.screens.favorite.favoriteLeagues

data class FavoriteLeagueUIState(
    val id: Int = 0,
    val leagueSeason: Int = 0,
    val imageUrl: String = "",
    val leagueName: String = "",
    val leagueCountry: String = "",
    val onFavorite: () -> Unit,
    val onFavoriteLeagueClick: (Int) -> Unit,
    val isFavourite: Boolean = false
)
