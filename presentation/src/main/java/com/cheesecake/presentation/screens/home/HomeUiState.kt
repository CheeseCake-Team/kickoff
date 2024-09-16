package com.cheesecake.presentation.screens.home

import java.util.Date

data class HomeUiState(
    val dateItems: List<DateItemUiState> = emptyList(),
    val currentDatePosition: Int = 0,
    val selectedDate: Date,
    val favoriteItems: List<FavoriteHomeItemUiState> = emptyList()
)