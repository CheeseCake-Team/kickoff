package com.cheesecake.presentation.screens.favLeaguesSelection

import com.cheesecake.domain.entity.League

data class FavLeagueSelectionUIState (
    val leaguesItems: List<FavLeagueItemUIState> = emptyList(),
    val selectedLeagues: MutableList<League> = mutableListOf(),
    val searchInput : String = "",
    val searchResult: List<FavLeagueItemUIState>? = emptyList(),
    val isLoading: Boolean = true,
    val errorMessage: String = ""
)