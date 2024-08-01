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
) : BaseViewModel<MatchEventUIState, MatchEventEvents>(
    MatchEventUIState(),
    Event()
) {
    val matchEventArgs = MatchEventArgs(savedStateHandle)

    init {
        getData()
    }

    private fun onSuccess(fixtureEvents: List<FixtureEvents>) {
        _state.update {
            it.copy(
                isLoading = false,
                data = fixtureEvents.toUIState(),
                noData = fixtureEvents.isEmpty()
            )
        }
    }

    override fun getData() {
        tryToExecute(
            { manageMatchesUseCase.getMatchEventByMatchId(matchEventArgs.fixtureId) },
            ::onSuccess,
        )
    }
}