package com.cheesecake.presentation.screens.player.playerStatistics

import com.cheesecake.domain.entity.PlayerStatistics
import com.cheesecake.domain.usecases.GetPlayerStatisticsUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toPlayerStatisticsUIModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PlayerStatisticsViewModel @Inject constructor(
    getPlayerStatisticsUseCase: GetPlayerStatisticsUseCase,
    playerStatisticsArgs: PlayerStatisticsArgs
) : BaseViewModel<PlayerStatisticsUIState, PlayerStatisticisNavigationEvent>
    (PlayerStatisticsUIState(), Event()) {

    init {
        tryToExecute(
            { getPlayerStatisticsUseCase(2022, playerStatisticsArgs.playerId) },
            ::onSuccess,
            ::onError
        )
    }

    private fun onSuccess(playerStatistics: PlayerStatistics) {
        _state.update { playerStatisticsUIState ->
            playerStatisticsUIState.copy(
                isLoading = false,
                data = playerStatistics.toPlayerStatisticsUIModel()
            )
        }
    }

    private fun onError(e: Throwable) {
        _state.update { it.copy(errorMessage = e.localizedMessage.toString()) }
    }

}