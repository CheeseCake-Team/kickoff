package com.cheesecake.presentation.screens.match.events

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.cheesecake.domain.entity.FixtureEvents
import com.cheesecake.domain.usecases.GetFixtureEventByFixtureIdUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MatchEventViewModel @Inject constructor(
    private val getFixtureEventByFixtureIdUseCase: GetFixtureEventByFixtureIdUseCase,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<MatchEventUIState, MatchEventEvents>(
    MatchEventUIState(),
    Event()
) {
    val matchEventArgs = MatchEventArgs(savedStateHandle)

    init {
        getMatchEvents()
    }

    private fun getMatchEvents() {
        tryToExecute(
            { getFixtureEventByFixtureIdUseCase(matchEventArgs.fixtureId) },
            ::onSuccess,
            ::onError
        )
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

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(
                errorMessage = e.localizedMessage ?: "Unknown error.",
                isLoading = false,
                noData = true
            )
        }
        Log.e("TAG", "onError: ${e.message.toString()}", )
    }
}