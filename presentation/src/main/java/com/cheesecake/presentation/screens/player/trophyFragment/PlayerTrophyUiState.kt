package com.cheesecake.presentation.screens.player.trophyFragment

data class PlayerTrophyUiState(
    val data:List<PlayerTrophyItemUiState> = emptyList(),
    val isLoading: Boolean = true,
    val errorMessage: String = "",
)