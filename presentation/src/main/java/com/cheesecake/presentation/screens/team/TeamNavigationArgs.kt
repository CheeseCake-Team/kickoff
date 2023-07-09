package com.cheesecake.presentation.screens.team

import androidx.lifecycle.SavedStateHandle
import com.cheesecake.presentation.screens.match.MatchFragmentArgs
import javax.inject.Inject

class TeamNavigationArgs @Inject constructor(savedStateHandle: SavedStateHandle) {
    val teamId: Int = TeamFragmentArgs.fromSavedStateHandle(savedStateHandle).teamId
}
