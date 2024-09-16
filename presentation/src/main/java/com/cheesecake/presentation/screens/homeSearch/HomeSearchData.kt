package com.cheesecake.presentation.screens.homeSearch


sealed class HomeSearchData{

    data class RecentSearches(
        val onClickDeleteAll: () -> Unit,
        val items: List<RecentSearchUiState> = emptyList(),
    ):HomeSearchData()

    data class PlayersTopScorers(
        val items: List<PlayersTopScorers> = emptyList(),
    ):HomeSearchData()


}
