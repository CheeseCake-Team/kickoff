package com.cheesecake.presentation.screens.home

data class HomeUiState(
    val isLoading: Boolean = true,
    val errorMessage: String = "Error",
    val dateItems: List<DateItemUiState> = emptyList(),
    val currentDatePosition: Int = 0,
    val favoriteItems: List<FavoriteHomeItemUiState> = emptyList()
)