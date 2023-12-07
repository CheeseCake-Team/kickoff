package com.cheesecake.presentation.screens.standings

import android.util.Log
import com.cheesecake.domain.entity.TeamStanding
import com.cheesecake.domain.usecases.GetTeamsStandingByLeagueIdAndSeasonUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
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
            }, ::onGettingTeamsStandingSuccess, ::onError
        )
    }

    private fun onGettingTeamsStandingSuccess(teamsStanding: List<TeamStanding>) {
        _state.update { standingUIState ->
            standingUIState.copy(
                data = teamsStanding.toUiState(),
                isLoading = false,
            )
        }
    }

    fun onError(error: Throwable) {
        Log.e("onStandingSuccess", error.message.toString())
        _state.update { it.copy(errorMessage = error.toString(), isLoading = false) }
    }

    fun onBackClick() {
        _event.update { Event(StandingNavigationEvent.NavigateBack) }
    }
}