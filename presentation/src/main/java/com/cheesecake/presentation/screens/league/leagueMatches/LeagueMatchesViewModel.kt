package com.cheesecake.presentation.screens.league.leagueMatches

import androidx.lifecycle.SavedStateHandle
import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.usecases.GetPairsOfMatchesAndDateByLeagueIdAndSeasonUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import com.cheesecake.presentation.screens.league.LeagueArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class LeagueMatchesViewModel @Inject constructor(
    private val getPairsOfMatchesAndDateByLeagueIdAndSeasonUseCase: GetPairsOfMatchesAndDateByLeagueIdAndSeasonUseCase,
    savedStateHandle: SavedStateHandle,

    ) : BaseViewModel<LeagueMatchesUIState, LeagueMatchesEvent>(LeagueMatchesUIState(), Event()) {

    private val leagueArg = LeagueArgs(savedStateHandle)

    init {
        getData()
    }

    private fun getData() {
        tryToExecute(
            { getPairsOfMatchesAndDateByLeagueIdAndSeasonUseCase("Africa/Cairo",  leagueArg.leagueId,  leagueArg.season) },
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