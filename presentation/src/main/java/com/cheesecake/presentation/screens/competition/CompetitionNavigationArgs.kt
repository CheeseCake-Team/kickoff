package com.cheesecake.presentation.screens.competition

import androidx.lifecycle.SavedStateHandle
import javax.inject.Inject

class CompetitionNavigationArgs @Inject constructor  (savedStateHandle: SavedStateHandle) {
    private val competitionArgs = CompetitionFragmentArgs.fromSavedStateHandle(savedStateHandle)
    val competitionId: Int = competitionArgs.id
}