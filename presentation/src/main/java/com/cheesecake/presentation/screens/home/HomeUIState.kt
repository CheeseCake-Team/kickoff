package com.cheesecake.presentation.screens.home

data class HomeUIState(
    val isLoading: Boolean = true,
    val errorMessage: String = "Error",
    val dateItems: List<DateItemUIState> = emptyList(),
    val favoriteItems: List<FavoriteHomeItemUIState> = emptyList()
)
