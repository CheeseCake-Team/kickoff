package com.cheesecake.presentation.screens.match.events

import androidx.lifecycle.SavedStateHandle
import com.cheesecake.domain.entity.FixtureEvents
import com.cheesecake.domain.usecases.ManageMatchesUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MatchEventViewModel @Inject constructor(
    private val manageMatchesUseCase: ManageMatchesUseCase,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<MatchEventUiState, MatchEventEvents>(
    MatchEventUiState(),
    Event()
) {
    val matchEventArgs = MatchEventArgs(savedStateHandle)

    init {
        getData()
    }

    private fun onSuccess(fixtureEvents: List<FixtureEvents>) {
        _isLoading.update { false }
        _errorUiState.update { null }
        _state.update {
            it.copy(
                data = fixtureEvents.toUIState(),
                noData = fixtureEvents.isEmpty()
            )
        }
    }

    override fun getData() {
        _isLoading.update { true }
        _errorUiState.update { null }
        tryToExecute(
            { manageMatchesUseCase.getMatchEventByMatchId(matchEventArgs.fixtureId) },
            ::onSuccess,
        )
    }
}