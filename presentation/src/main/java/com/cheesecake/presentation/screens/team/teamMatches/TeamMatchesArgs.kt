package com.cheesecake.presentation.screens.team.teamMatches

import androidx.lifecycle.SavedStateHandle
import javax.inject.Inject

class TeamMatchesArgs @Inject constructor(savedStateHandle: SavedStateHandle) {
    val teamId: Int = checkNotNull(savedStateHandle[TEAM_ID_ARG])
//    val season: Int = checkNotNull(savedStateHandle[SEASON_ARG])


    companion object {
        const val TEAM_ID_ARG = "TeamMatchesArgsTeamID"
        const val SEASON_ARG = "TeamMatchesArgsSeason"
    }
}