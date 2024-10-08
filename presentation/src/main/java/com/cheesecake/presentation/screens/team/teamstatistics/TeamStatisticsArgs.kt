package com.cheesecake.presentation.screens.team.teamstatistics

import androidx.lifecycle.SavedStateHandle
import javax.inject.Inject

class TeamStatisticsArgs @Inject constructor(savedStateHandle: SavedStateHandle) {
    val teamId: Int = checkNotNull(savedStateHandle[TEAM_ID_ARG])
    val season: Int = checkNotNull(savedStateHandle[SEASON_ARG])

    companion object {
        const val TEAM_ID_ARG = "TeamStatisticsTeamID"
        const val COMPETITION_ID_ARG = "TeamStatisticsCompetitionId"
        const val SEASON_ARG = "TeamStatisticsSeason"
    }
}