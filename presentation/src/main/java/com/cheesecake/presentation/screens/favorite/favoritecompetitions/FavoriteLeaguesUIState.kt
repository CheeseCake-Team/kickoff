package com.cheesecake.presentation.screens.favorite.favoritecompetitions

data class FavoriteLeaguesUIState(
    val competitions: List<FavoriteCompetitionsUiState> = emptyList(),
    val isLeaguesIsEmpty: Boolean = false,
    val isLoading: Boolean = true,
    val errorMessage: String = ""
)
