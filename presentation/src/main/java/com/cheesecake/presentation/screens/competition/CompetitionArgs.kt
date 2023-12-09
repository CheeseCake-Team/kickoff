package com.cheesecake.presentation.screens.competition

import androidx.lifecycle.SavedStateHandle

class CompetitionArgs(savedStateHandle: SavedStateHandle) {
    val competitionId: Int = checkNotNull(savedStateHandle[COMPETITION_ID_ARG])
    val season: Int = checkNotNull(savedStateHandle[SEASON_ARG])

    companion object {
        const val COMPETITION_ID_ARG = "competitionId"
        const val SEASON_ARG = "leagueSeason"
    }
}