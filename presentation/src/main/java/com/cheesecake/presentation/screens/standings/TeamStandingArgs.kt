package com.cheesecake.presentation.screens.standings

import androidx.lifecycle.SavedStateHandle
import javax.inject.Inject

class TeamsStandingArgs @Inject constructor(savedStateHandle: SavedStateHandle) {
    val leagueId: Int = StandingsFragmentArgs.fromSavedStateHandle(savedStateHandle).leagueId
    val season: Int = StandingsFragmentArgs.fromSavedStateHandle(savedStateHandle).season
}