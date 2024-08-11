package com.cheesecake.presentation.screens.search.viewAll.competitions

import com.cheesecake.presentation.screens.search.models.CompetitionSearchUiState

data class CompetitionsSearchUiState(
    val items: List<CompetitionSearchUiState> = emptyList(),
    val isResultEmpty: Boolean = false
)

