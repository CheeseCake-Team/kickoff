package com.cheesecake.presentation.screens.player

import androidx.lifecycle.SavedStateHandle
import javax.inject.Inject

class PlayerNavigationArgs @Inject constructor(savedStateHandle: SavedStateHandle) {
    private val playerArgs = PlayerFragmentArgs.fromSavedStateHandle(savedStateHandle)
    val playerId: Int = playerArgs.playerId

}