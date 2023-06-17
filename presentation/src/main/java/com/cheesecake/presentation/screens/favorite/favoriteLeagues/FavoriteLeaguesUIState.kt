package com.cheesecake.presentation.screens.favorite.favoriteLeagues

data class FavoriteLeaguesUIState(
    val leagues: List<FavoriteLeagueUIState> = emptyList(),
    val isLeaguesIsEmpty: Boolean = false,
    val isLoading: Boolean = true,
    val errorMessage: String = ""
)
