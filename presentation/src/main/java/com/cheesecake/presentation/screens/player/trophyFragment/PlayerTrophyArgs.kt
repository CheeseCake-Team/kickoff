package com.cheesecake.presentation.screens.player.trophyFragment

import androidx.lifecycle.SavedStateHandle
import javax.inject.Inject

class PlayerTrophyArgs @Inject constructor(savedStateHandler: SavedStateHandle) {
    val playerId: Int = checkNotNull(savedStateHandler[PLAYER_ID])

    companion object {
        const val PLAYER_ID = "PlayerId"
    }
}