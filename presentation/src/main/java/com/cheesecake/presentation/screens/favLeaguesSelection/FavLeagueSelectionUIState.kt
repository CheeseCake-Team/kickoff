package com.cheesecake.presentation.screens.favLeaguesSelection

import com.cheesecake.domain.entity.League

data class FavLeagueSelectionUIState (
    val allLeagues: List<League> = emptyList(),
    val isLoading: Boolean = true,
    val errorMessage: String = ""
)