package com.cheesecake.presentation.screens.home

data class FavoriteItemUIState(
    val title: String = "",
    val data: List<DateMatchItemUIState> = emptyList(),
)
