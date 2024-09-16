package com.cheesecake.presentation.screens.favoriteteamsselection

data class FavoriteTeamsSelectionUiState(
    val teamsItemsUiState: List<SelectedTeamItemUiState> = emptyList(),
    val displayedTeams: List<SelectedTeamItemUiState> = emptyList(),
    val searchInput : String = "",
    val isNoResult: Boolean = false,
    val onGetStartedClick: () -> Unit = { },
)