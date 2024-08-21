package com.cheesecake.presentation.screens.season

data class SeasonUiState(
    val selectedSeason: String = "",
    val seasonItemUiState: List<SeasonItemUiState> = emptyList()
)