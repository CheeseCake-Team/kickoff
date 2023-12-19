package com.cheesecake.presentation.screens.player.trophyFragment

import com.cheesecake.domain.entity.Trophy
import com.cheesecake.domain.usecases.GetPlayerTrophyUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PlayerTrophyViewModel @Inject constructor(
    private val getPlayerTrophyUseCase: GetPlayerTrophyUseCase,
    playerTrophyArgs: PlayerTrophyArgs
) : BaseViewModel<PlayerTrophyUiState, Event<TrophyNavigationEvent>>(
    PlayerTrophyUiState(),
    Event()
) {

    init {
        tryToExecute(
            { getPlayerTrophyUseCase(playerTrophyArgs.playerId) },
            ::onGettingPlayerTrophySuccess,
            ::onError
        )
    }

    private fun onGettingPlayerTrophySuccess(trophies: List<Trophy>) {
        _state.update { it.copy(data = trophies.toUiState(), isLoading = false) }
    }

    private fun onError(e: Throwable) {
        _state.update { it.copy(isLoading = false, errorMessage = e.message.toString()) }
    }
}