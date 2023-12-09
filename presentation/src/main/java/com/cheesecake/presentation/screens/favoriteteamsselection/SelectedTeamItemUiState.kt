package com.cheesecake.presentation.screens.favoriteteamsselection

data class SelectedTeamItemUiState(
    val teamId : Int = 0,
    val teamName: String = "",
    val imageUrl: String = "",
    val isSelected: Boolean = false,
    val onClick: () -> Unit,
)