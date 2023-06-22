package com.cheesecake.presentation.screens.team.teamMatches

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.usecases.GetTeamMatchesByTeamIdAndSeasonUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TeamMatchesViewModel @Inject constructor(
    private val getPairsOfMatchesAndDateByTeamIdAndSeasonUseCase:
    GetTeamMatchesByTeamIdAndSeasonUseCase
)
    : BaseViewModel<TeamMatchesUIState, TeamMatchesNavigationEvent>(TeamMatchesUIState(), Event()){

    init {
        getData()
    }

    private fun getData() {
        tryToExecute(
            { getPairsOfMatchesAndDateByTeamIdAndSeasonUseCase("Africa/Cairo", 34, 2022) },
            ::onSuccess,
            ::onError
        )
    }

    private fun onSuccess(result: List<Fixture>) {
        _state.update { it.copy(data = result, isLoading = false) }
    }

    private fun onError(error: Throwable) {
        _state.update { it.copy(errorMessage = error.message.toString(), isLoading = false) }
    }
}