package com.cheesecake.presentation.screens.league

import androidx.lifecycle.SavedStateHandle

class LeagueArgs(savedStateHandle: SavedStateHandle) {
    val leagueId: Int = savedStateHandle[LEAGUE_ID_ARG] ?: 0
    val season: Int = savedStateHandle[SEASON_ARG] ?: 0

    companion object{
        const val LEAGUE_ID_ARG = "leagueID"
        const val SEASON_ARG = "leagueSeason"
    }
}
