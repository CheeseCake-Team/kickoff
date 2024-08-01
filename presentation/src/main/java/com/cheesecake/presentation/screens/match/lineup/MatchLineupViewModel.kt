package com.cheesecake.presentation.screens.match.lineup

import androidx.lifecycle.SavedStateHandle
import com.cheesecake.domain.entity.FixtureLineup
import com.cheesecake.domain.usecases.ManageMatchesUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MatchLineupViewModel @Inject constructor(
    private val manageMatchesUseCase: ManageMatchesUseCase,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<MatchLineupUIState, MatchLineupEvents>(
    MatchLineupUIState(),
    Event()
) {
    private val matchLineupsArgs = MatchLineupsArgs(savedStateHandle)
    val matchState = matchLineupsArgs.state

    init {
        getData()
    }

    private fun onSuccess(getFixtureId: List<FixtureLineup>) {
        _state.update {
            it.copy(
                data = getFixtureId.toUIState(),
                teams = getFixtureId.toTeamsUIState(),
                isLoading = false,
                noData = getFixtureId.isEmpty()
            )
        }
    }

    override fun getData() {
        tryToExecute(
            { manageMatchesUseCase.getMatchLineupByMatchId(matchLineupsArgs.fixtureId) },
            ::onSuccess,
        )
    }
}