package com.cheesecake.presentation.screens.favorite.favoritecompetitions

data class FavoriteCompetitionsUiState(
    val id: Int = 0,
    val leagueSeason: Int = 0,
    val imageUrl: String = "",
    val leagueName: String = "",
    val leagueCountry: String = "",
    val onFavorite: () -> Unit,
    val onFavoriteLeagueClick: () -> Unit,
    val isFavourite: Boolean = false
)
