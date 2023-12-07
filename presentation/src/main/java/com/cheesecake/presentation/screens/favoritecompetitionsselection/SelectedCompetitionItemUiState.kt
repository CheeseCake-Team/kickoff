package com.cheesecake.presentation.screens.favoritecompetitionsselection

data class SelectedCompetitionItemUiState(
    val competitionId : Int = 0,
    val imageUrl: String = "",
    val competitionName: String = "",
    val isSelected: Boolean = false,
    val onClick: () -> Unit,
)