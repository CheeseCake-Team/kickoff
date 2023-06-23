package com.cheesecake.presentation.screens.league

import androidx.lifecycle.SavedStateHandle

class LeagueArgs(savedStateHandle: SavedStateHandle) {
    val leagueId: Int = checkNotNull(savedStateHandle[LEAGUE_ID_ARG])
    val season: Int = checkNotNull(savedStateHandle[SEASON_ARG])

    companion object{
        const val LEAGUE_ID_ARG = "leagueID"
        const val SEASON_ARG = "leagueSeason"
    }
}
