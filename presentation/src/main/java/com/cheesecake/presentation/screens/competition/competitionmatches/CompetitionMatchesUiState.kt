package com.cheesecake.presentation.screens.competition.competitionmatches

import com.cheesecake.presentation.screens.home.MatchItemUiState

data class CompetitionMatchesUiState(
    val data: List<DateMatchesItemUiState> = emptyList(),
    val errorMessage: String = "",
    val isLoading: Boolean = true
)

data class DateMatchesItemUiState(
    val date: String = "",
    val matches: List<MatchItemUiState> = emptyList()
)