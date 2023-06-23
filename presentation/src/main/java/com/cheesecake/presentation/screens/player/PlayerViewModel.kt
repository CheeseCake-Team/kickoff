package com.cheesecake.presentation.screens.player

import com.cheesecake.domain.entity.Player
import com.cheesecake.domain.usecases.GetPlayerUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(
    getPlayerUseCase: GetPlayerUseCase,
    val playerNavigationArgs: PlayerNavigationArgs
) : BaseViewModel<PlayerUiState, PlayerNavigationEvent>(PlayerUiState(), Event()) {

    init {
        tryToExecute(
            { getPlayerUseCase(2022, playerNavigationArgs.playerId) },
            ::onSuccess,
            ::onError
        )
    }

    private fun onSuccess(player: Player) {
        _state.update { playerUIState ->
            playerUIState.copy(
                playerName = player.name,
                playerImageUrl = player.photo,
                onBackClick = { onBackClick() }
            )
        }
    }

    private fun onError(e: Throwable) {
        _state.update { playerUIState ->
            playerUIState.copy(errorMessage = e.localizedMessage.toString())
        }
    }

    private fun onBackClick() {
        _event.update { Event(PlayerNavigationEvent.NavigateBack) }
    }

}