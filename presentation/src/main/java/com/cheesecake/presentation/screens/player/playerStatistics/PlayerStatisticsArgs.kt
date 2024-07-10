package com.cheesecake.presentation.screens.player.playerStatistics

import androidx.lifecycle.SavedStateHandle
import javax.inject.Inject

class PlayerStatisticsArgs @Inject constructor(savedStateHandler: SavedStateHandle) {
    val playerId: Int = checkNotNull(savedStateHandler[PLAYER_ID])
    val season: Int = checkNotNull(savedStateHandler[SEASON])

    companion object {
        const val PLAYER_ID = "PlayerId"
        const val SEASON = "season"
    }
}