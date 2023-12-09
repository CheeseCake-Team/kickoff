package com.cheesecake.presentation.screens.home

data class FavoriteHomeItemUIState(
    val title: String = "",
    val imageUrl: String = "",
    val competitionId: Int = 0,
    val isNoData: Boolean = false,
    val season: Int = 0,
    val onclick: (leagueId: Int, season: Int) -> Unit = { _, _ -> },
    val matches: List<MatchItemUiState> = emptyList(),
)