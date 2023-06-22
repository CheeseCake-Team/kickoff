package com.cheesecake.presentation.screens.match.lineup

import androidx.lifecycle.SavedStateHandle
import com.cheesecake.domain.entity.FixtureLineup
import com.cheesecake.domain.usecases.GetFixtureLineupByFixtureIdUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MatchLineupViewModel @Inject constructor(
    private val getFixtureLineupByFixtureId: GetFixtureLineupByFixtureIdUseCase,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<MatchLineupUIState, MatchLineupEvents>(
    MatchLineupUIState(),
    Event()
) {
    init {
        tryToExecute(
            { getFixtureLineupByFixtureId(157201) },
            ::onSuccess,
            ::onError
        )

    }

    private fun onSuccess(getFixtureId: List<FixtureLineup>) {
        _state.update {
            it.copy(
                data = getFixtureId.toUIState(),
                isLoading = false
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