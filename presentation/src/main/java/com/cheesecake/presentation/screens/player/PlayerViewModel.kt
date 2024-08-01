package com.cheesecake.presentation.screens.player

import com.cheesecake.domain.entity.PlayerStatistics
import com.cheesecake.domain.usecases.ManagePlayersUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(
    private val managePlayersUseCase: ManagePlayersUseCase,
    val playerNavigationArgs: PlayerNavigationArgs
) : BaseViewModel<PlayerUiState, PlayerNavigationEvent>(PlayerUiState(), Event()) {
    init {
        getData()
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

    fun onBackClick() {
        _event.update { Event(PlayerNavigationEvent.NavigateBack) }
    }

    override fun getData() {
        tryToExecute(
            {
                managePlayersUseCase.getPlayerStatistics(
                    playerNavigationArgs.season,
                    playerNavigationArgs.playerId
                )
            },
            ::onSuccess,
        )
    }
}