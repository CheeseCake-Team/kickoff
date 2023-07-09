package com.cheesecake.presentation.screens.standings

import android.util.Log
import com.cheesecake.domain.entity.TeamStanding
import com.cheesecake.domain.usecases.GetTeamsStandingByLeagueIdAndSeasonUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toTeamStandingItemUIState
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class StandingsViewModel @Inject constructor(
    private val getTeamsStandingByLeagueIdAndSeasonUseCase: GetTeamsStandingByLeagueIdAndSeasonUseCase,
    teamsStandingArgs: TeamsStandingArgs
) : BaseViewModel<StandingsUiState, StandingNavigationEvent>(StandingsUiState(), Event()) {

    init {
        tryToExecute(
            {
                getTeamsStandingByLeagueIdAndSeasonUseCase(
                    teamsStandingArgs.leagueId, teamsStandingArgs.season
                )
            }, ::onStandingSuccess, ::onError)
    }

    private fun onStandingSuccess(standings: List<TeamStanding>) {
        _state.update { standingUIState ->
            Log.e("onStandingSuccess", "called")
            standingUIState.copy(
                data = standings.map { it.toTeamStandingItemUIState() },
                isLoading = false,
                onBackClick = { onBackClick() }
            )
        }
    }

    fun onError(error: Throwable) {
        Log.e("onStandingSuccess", error.message.toString())
        _state.update { it.copy(errorMessage = error.toString(), isLoading = false) }
    }

    private fun onBackClick() {
        _event.update { Event(StandingNavigationEvent.NavigateBack) }
    }
}