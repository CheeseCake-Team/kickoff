package com.cheesecake.presentation.screens.match.events

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
) : BaseViewModel<MatchEventUIState, MatchEventEvents>(
    MatchEventUIState(),
    Event()
) {

    init {
        getMatchEvents()
    }

    private fun getMatchEvents() {
        tryToExecute(
            { getFixtureEventByFixtureIdUseCase(215662) },
            ::onSuccess,
            ::onError
        )
    }

    private fun onSuccess(fixtureEvents: List<FixtureEvents>) {
        _state.update {
            it.copy(
                isLoading = false,
                data = fixtureEvents.toUIState()
            )
        }
    }


    private fun onError(e: Throwable) {
        _state.update {
            it.copy(
                errorMessage = e.localizedMessage ?: "Unknown error.",
                isLoading = false
            )
        }
    }
}