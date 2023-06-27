package com.cheesecake.presentation.screens.match.events

import androidx.lifecycle.SavedStateHandle

class MatchEventArgs(savedStateHandle: SavedStateHandle) {
    val fixtureId: Int = checkNotNull(savedStateHandle[MATCH_FIXTURE_ID_ARG])
    val homeTeamId: Int = checkNotNull(savedStateHandle[HOME_TEAM_ID_ARG])
    val awayTeamId: Int = checkNotNull(savedStateHandle[AWAY_TEAM_ID_ARG])
    val state: String = savedStateHandle[FIXTURE_STATUS] ?: " "

    companion object {
        const val MATCH_FIXTURE_ID_ARG = "matchFixtureID"
        const val HOME_TEAM_ID_ARG = "HomeTeamId"
        const val AWAY_TEAM_ID_ARG = "awayTeamId"
        const val FIXTURE_STATUS = "fixturestatus"
    }
}

