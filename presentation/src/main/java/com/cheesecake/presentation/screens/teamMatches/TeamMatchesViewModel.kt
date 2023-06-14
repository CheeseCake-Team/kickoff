package com.cheesecake.presentation.screens.teamMatches

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.usecases.GetPairsOfMatchesAndDateByTeamIdAndSeasonUseCase
import com.cheesecake.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class TeamMatchesViewModel @Inject constructor(
    private val getPairsOfMatchesAndDateByTeamIdAndSeasonUseCase:
    GetPairsOfMatchesAndDateByTeamIdAndSeasonUseCase
)
    : BaseViewModel<TeamMatchesUIState>(TeamMatchesUIState()){

    init {
        getData()
    }

    private fun getData() {
        tryToExecute(
            { getPairsOfMatchesAndDateByTeamIdAndSeasonUseCase("Africa/Cairo", 39, 2022) },
            ::onSuccess,
            ::onError
        )
    }

    private fun onSuccess(result: List<Pair<String, List<Fixture>>>) {
        _state.update { it.copy(data = result, isLoading = false) }
    }

    private fun onError(error: Throwable) {
        _state.update { it.copy(errorMessage = error.message.toString(), isLoading = false) }
    }
}