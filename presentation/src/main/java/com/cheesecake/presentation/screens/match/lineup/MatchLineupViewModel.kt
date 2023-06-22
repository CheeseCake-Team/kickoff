package com.cheesecake.presentation.screens.match.lineup

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.cheesecake.domain.entity.FixtureLineup
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.GetFixtureLineupByFixtureIdUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import com.google.android.material.color.utilities.MaterialDynamicColors.onError
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
    private fun onSuccess(getFixtureId:List <FixtureLineup>)   {
        Log.d("TAAAAAAG","$getFixtureId")

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