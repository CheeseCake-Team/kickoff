package com.cheesecake.presentation.screens.match

import androidx.lifecycle.SavedStateHandle
import javax.inject.Inject

class MatchNavigationArgs @Inject constructor(savedStateHandle: SavedStateHandle) {
    val homeTeamId: Int = MatchFragmentArgs.fromSavedStateHandle(savedStateHandle).homeTeamId
    val awayTeamId: Int = MatchFragmentArgs.fromSavedStateHandle(savedStateHandle).awayTeamId
    val date: String = MatchFragmentArgs.fromSavedStateHandle(savedStateHandle).data
}
