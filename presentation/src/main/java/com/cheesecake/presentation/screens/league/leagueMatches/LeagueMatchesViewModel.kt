package com.cheesecake.presentation.screens.league.leagueMatches

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.usecases.GetPairsOfMatchesAndDateByLeagueIdAndSeasonUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import com.cheesecake.presentation.screens.league.LeagueArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LeagueMatchesViewModel @Inject constructor(
    private val getPairsOfMatchesAndDateByLeagueIdAndSeasonUseCase: GetPairsOfMatchesAndDateByLeagueIdAndSeasonUseCase,
    savedStateHandle: SavedStateHandle,

    ) : BaseViewModel<LeagueMatchesUIState, LeagueMatchesEvent>(LeagueMatchesUIState(), Event()) {

    private val leagueArgs = LeagueArgs(savedStateHandle)

    init {
        tryToExecute(
            {
                getPairsOfMatchesAndDateByLeagueIdAndSeasonUseCase(
                    "Africa/Cairo",
                    leagueArgs.leagueId,
                    leagueArgs.season
                )
            },
            ::onSuccess,
            ::onError
        )

    }


    private fun onSuccess(result: List<Pair<String, List<Fixture>>>) {
        _state.update { it.copy(data = result.toUIState(::onMatchClicked), isLoading = false) }
    }

    private fun onError(error: Throwable) {
        _state.update { it.copy(errorMessage = error.message.toString(), isLoading = false) }
    }

    private fun onMatchClicked(homeTeamId: Int, awayTeamId: Int, date: String) {
        _event.update { Event(LeagueMatchesEvent.MatchClickedEvent(homeTeamId, awayTeamId, date)) }
    }
}

