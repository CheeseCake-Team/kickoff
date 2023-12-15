package com.cheesecake.presentation.screens.team

import androidx.lifecycle.SavedStateHandle
import javax.inject.Inject

class TeamNavigationArgs @Inject constructor(savedStateHandle: SavedStateHandle) {
    val teamId: Int = TeamFragmentArgs.fromSavedStateHandle(savedStateHandle).teamId
    val season: Int = TeamFragmentArgs.fromSavedStateHandle(savedStateHandle).season
    val competitionId: Int = TeamFragmentArgs.fromSavedStateHandle(savedStateHandle).competitionId
}