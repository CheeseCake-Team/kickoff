package com.cheesecake.presentation.screens.home

data class FavoriteHomeItemUIState(
    val title: String = "",
    val imageUrl: String = "",
    val data: List<DateMatchItemUIState> = emptyList(),
)
