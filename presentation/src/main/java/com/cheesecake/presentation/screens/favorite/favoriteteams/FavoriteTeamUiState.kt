package com.cheesecake.presentation.screens.favorite.favoriteteams

data class FavoriteTeamUiState(
    val teams: List<FavoriteTeamItemUiState> = emptyList(),
    val isTeamsIsEmpty: Boolean = false,
    val isLoading: Boolean = true,
    val errorMessage: String = ""
)
