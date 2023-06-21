package com.cheesecake.presentation.screens.match

import androidx.lifecycle.SavedStateHandle
import javax.inject.Inject

class MatchNavigationArgs @Inject constructor(savedStateHandle: SavedStateHandle) {
    val matchId: String = MatchFragmentArgs.fromSavedStateHandle(savedStateHandle).matchId
    val date: String = MatchFragmentArgs.fromSavedStateHandle(savedStateHandle).data
}
