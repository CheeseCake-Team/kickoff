package com.cheesecake.presentation.screens.player.playerStatistics

import com.cheesecake.domain.entity.PlayerStatistics
import com.cheesecake.domain.usecases.ManagePlayersUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PlayerStatisticsViewModel @Inject constructor(
    private val managePlayersUseCase: ManagePlayersUseCase,
    private val playerStatisticsArgs: PlayerStatisticsArgs
) : BaseViewModel<PlayerStatisticsUiState, PlayerStatisticsNavigationEvent>
    (PlayerStatisticsUiState(), Event()) {
    init {
        getData()
    }

    private fun onGettingPlayerStatisticsSuccess(playerStatistics: PlayerStatistics) {
        _errorUiState.update { null }
        _isLoading.update { false }
        _state.update { it.copy(data = playerStatistics.toUiState()) }
    }

    override fun getData() {
        _errorUiState.update { null }
        _isLoading.update { true }
        tryToExecute(
            {
                managePlayersUseCase.getPlayerStatistics(
                    playerStatisticsArgs.season,
                    playerStatisticsArgs.playerId
                )
            },
            ::onGettingPlayerStatisticsSuccess,
        )
    }
}