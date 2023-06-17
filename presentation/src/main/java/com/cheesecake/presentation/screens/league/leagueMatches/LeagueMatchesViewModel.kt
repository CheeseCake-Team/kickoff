package com.cheesecake.presentation.screens.league.leagueMatches

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.usecases.GetPairsOfMatchesAndDateByLeagueIdAndSeasonUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class LeagueMatchesViewModel @Inject constructor(
    private val getPairsOfMatchesAndDateByLeagueIdAndSeasonUseCase: GetPairsOfMatchesAndDateByLeagueIdAndSeasonUseCase,
) : BaseViewModel<LeagueMatchesUIState, LeagueMatchesEvent>(LeagueMatchesUIState(), Event()) {


    init {
        getData()
    }

    private fun getData() {
        tryToExecute(
            { getPairsOfMatchesAndDateByLeagueIdAndSeasonUseCase("Africa/Cairo", 39, 2022) },
            ::onSuccess,
            ::onError
        )
    }

    private fun onSuccess(result: List<Pair<Date, List<Fixture>>>) {
        _state.update { it.copy(data = result, isLoading = false) }
    }

    private fun onError(error: Throwable) {
        _state.update { it.copy(errorMessage = error.message.toString(), isLoading = false) }
    }

}