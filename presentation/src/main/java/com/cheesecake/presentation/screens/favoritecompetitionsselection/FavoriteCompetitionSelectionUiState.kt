package com.cheesecake.presentation.screens.favoritecompetitionsselection

import kotlinx.coroutines.flow.MutableStateFlow

data class FavoriteCompetitionSelectionUiState (
    val displayedCompetitions: List<SelectedCompetitionItemUiState> = emptyList(),
    val competitionsItemUiState: List<SelectedCompetitionItemUiState> = emptyList(),
    val searchQuery : MutableStateFlow<String> = MutableStateFlow(""),
    val isNoResult: Boolean = false,
    val onNextClick: () -> Unit = { },
)