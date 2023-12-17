package com.cheesecake.presentation.screens.home

data class HomeUIState(
    val isLoading: Boolean = true,
    val errorMessage: String = "Error",
    val dateItems: List<DateItemUiState> = emptyList(),
    val currentDatePosition: Int = 0,
    val favoriteItems: List<FavoriteHomeItemUIState> = emptyList()
)