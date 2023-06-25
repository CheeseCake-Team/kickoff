package com.cheesecake.presentation.screens.team.teamPlayers

import androidx.lifecycle.SavedStateHandle
import javax.inject.Inject

class TeamPlayersArgs @Inject constructor(savedStateHandle: SavedStateHandle) {
    val teamId: Int = checkNotNull(savedStateHandle[TEAM_ID_ARG])

    companion object {
        const val TEAM_ID_ARG = "TeamPlayersTeamID"
    }
}