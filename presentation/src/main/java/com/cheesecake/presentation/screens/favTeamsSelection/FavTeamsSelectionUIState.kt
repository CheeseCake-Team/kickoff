package com.cheesecake.presentation.screens.favTeamsSelection

import kotlinx.coroutines.flow.MutableStateFlow

data class FavTeamsSelectionUIState(
    val teamsItems: List<FavTeamItemUIState> = emptyList(),
    val searchResult: List<FavTeamItemUIState>? = emptyList(),
    val searchInput : MutableStateFlow<String> = MutableStateFlow(""),
    val isLoading: Boolean = true,
    val isNoResult: Boolean = false,
    val errorMessage: String = "",
    val onGetStartedClick: () -> Unit = { },
)