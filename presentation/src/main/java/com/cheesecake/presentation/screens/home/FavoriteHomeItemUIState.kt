package com.cheesecake.presentation.screens.home

data class FavoriteHomeItemUIState(
    val title: String = "",
    val imageUrl: String = "",
    val matches: List<MatchItemUIState> = emptyList(),
)
