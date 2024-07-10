package com.cheesecake.presentation.screens.player.playerStatistics

import com.cheesecake.domain.entity.PlayerStatistics
import com.cheesecake.domain.usecases.GetPlayerStatisticsUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PlayerStatisticsViewModel @Inject constructor(
    getPlayerStatisticsUseCase: GetPlayerStatisticsUseCase,
    playerStatisticsArgs: PlayerStatisticsArgs
) : BaseViewModel<PlayerStatisticsUIState, PlayerStatisticsNavigationEvent>
    (PlayerStatisticsUIState(), Event()) {
    init {
        tryToExecute(
            {
                getPlayerStatisticsUseCase(
                    playerStatisticsArgs.season,
                    playerStatisticsArgs.playerId
                )
            },
            ::onGettingPlayerStatisticsSuccess,
            ::onError
        )
    }

    private fun onGettingPlayerStatisticsSuccess(playerStatistics: PlayerStatistics) {
        _state.update { playerStatisticsUIState ->
            playerStatisticsUIState.copy(
                isLoading = false,
                data = playerStatistics.toUiState()
            )
        }
    }

    private fun onError(e: Throwable) {
        _state.update { it.copy(errorMessage = e.localizedMessage.toString()) }
    }
}