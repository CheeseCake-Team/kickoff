package com.cheesecake.presentation.screens.player

import com.cheesecake.domain.entity.PlayerStatistics
import com.cheesecake.domain.usecases.GetPlayerStatisticsUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(
    getPlayerStatisticsUseCase: GetPlayerStatisticsUseCase,
    val playerNavigationArgs: PlayerNavigationArgs
) : BaseViewModel<PlayerUiState, PlayerNavigationEvent>(PlayerUiState(), Event()) {
    init {
        tryToExecute(
            {
                getPlayerStatisticsUseCase(
                    playerNavigationArgs.season,
                    playerNavigationArgs.playerId
                )
            },
            ::onSuccess,
            ::onError
        )
    }

    private fun onSuccess(playerStatistics: PlayerStatistics) {
        _state.update {
            it.copy(
                playerName = playerStatistics.name,
                playerImageUrl = playerStatistics.imageUrl,
                teamCountry = playerStatistics.competitionCountry,
                teamName = playerStatistics.teamName
            )
        }
    }

    private fun onError(e: Throwable) {
        _state.update { playerUIState ->
            playerUIState.copy(errorMessage = e.localizedMessage.toString())
        }
    }

    fun onBackClick() {
        _event.update { Event(PlayerNavigationEvent.NavigateBack) }
    }
}