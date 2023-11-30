package com.cheesecake.presentation.screens.favoritecompetitionsselection

import kotlinx.coroutines.flow.MutableStateFlow

data class FavoriteCompetitionSelectionUiState (
    val displayedCompetitions: List<SelectedCompetitionItemUiState> = emptyList(),
    val competitionsItemUiState: List<SelectedCompetitionItemUiState> = emptyList(),
    val searchQuery : MutableStateFlow<String> = MutableStateFlow(""),
    val isLoading: Boolean = true,
    val isNoResult: Boolean = false,
    val errorMessage: String = "",
    val onNextClick: () -> Unit = { },
)