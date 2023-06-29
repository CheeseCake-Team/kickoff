package com.cheesecake.presentation.screens.favLeaguesSelection

import kotlinx.coroutines.flow.MutableStateFlow

data class FavLeagueSelectionUIState (
    val leaguesItems: List<FavLeagueItemUIState> = emptyList(),
    val searchResult: List<FavLeagueItemUIState>? = emptyList(),
    val searchInput : MutableStateFlow<String> = MutableStateFlow(""),
    val isLoading: Boolean = true,
    val isNoResult: Boolean = false,
    val errorMessage: String = "",
    val onNextClick: () -> Unit = { },
    val onSkipClick: () -> Unit = { }
)