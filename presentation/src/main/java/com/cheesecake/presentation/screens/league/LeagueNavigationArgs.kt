package com.cheesecake.presentation.screens.league

import androidx.lifecycle.SavedStateHandle

class LeagueNavigationArgs(savedStateHandle: SavedStateHandle) {
    private val leagueArgs = LeagueFragmentArgs.fromSavedStateHandle(savedStateHandle)
    val leagueId: Int = leagueArgs.id
    val season: Int = leagueArgs.season
}
