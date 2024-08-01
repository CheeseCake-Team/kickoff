package com.cheesecake.presentation.screens.player.trophyFragment

import com.cheesecake.domain.entity.Trophy
import com.cheesecake.domain.usecases.ManagePlayersUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PlayerTrophyViewModel @Inject constructor(
    private val managePlayersUseCase: ManagePlayersUseCase,
    private val playerTrophyArgs: PlayerTrophyArgs
) : BaseViewModel<PlayerTrophyUiState, Event<TrophyNavigationEvent>>(
    PlayerTrophyUiState(),
    Event()
) {
    init {
        getData()
    }

    private fun onGettingPlayerTrophySuccess(trophies: List<Trophy>) {
        _state.update { it.copy(data = trophies.toUiState(), isLoading = false) }
    }

    override fun getData() {
        tryToExecute(
            { managePlayersUseCase.getPlayerTrophy(playerTrophyArgs.playerId) },
            ::onGettingPlayerTrophySuccess,
        )
    }
}