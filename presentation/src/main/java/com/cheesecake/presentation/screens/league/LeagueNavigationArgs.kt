package com.cheesecake.presentation.screens.league

import androidx.lifecycle.SavedStateHandle
import javax.inject.Inject

class LeagueNavigationArgs @Inject constructor  (savedStateHandle: SavedStateHandle) {
    private val leagueArgs = LeagueFragmentArgs.fromSavedStateHandle(savedStateHandle)
    val leagueId: Int = leagueArgs.id
    val season: Int = leagueArgs.season
}
