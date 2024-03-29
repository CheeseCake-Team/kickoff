package com.cheesecake.presentation.screens.team.teamMatches

import android.util.Log
import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.usecases.GetTeamMatchesByTeamIdAndSeasonUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toTeamMatchItemUIState
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TeamMatchesViewModel @Inject constructor(
    private val getPairsOfMatchesAndDateByTeamIdAndSeasonUseCase: GetTeamMatchesByTeamIdAndSeasonUseCase,
    teamMatchesArgs: TeamMatchesArgs
) : BaseViewModel<TeamMatchesUIState, TeamMatchesNavigationEvent>(TeamMatchesUIState(), Event()) {

    init {
        tryToExecute(
            {
                getPairsOfMatchesAndDateByTeamIdAndSeasonUseCase(
                    "Africa/Cairo", teamMatchesArgs.teamId, 2022
                )
            }, ::onSuccess, ::onError
        )

    }


    private fun onSuccess(result: List<Fixture>) {
        _state.update {
            it.copy(
                data = result.map { fixture ->
                    fixture.toTeamMatchItemUIState(::onMatchClicked)
                },
                isLoading = false
            )
        }
    }

    private fun onError(error: Throwable) {
        _state.update { it.copy(errorMessage = error.message.toString(), isLoading = false) }
    }

    private fun onMatchClicked(homeTeamId: Int, awayTeamId: Int, date: String) {
        _event.update {
            Event(TeamMatchesNavigationEvent.MatchClickedEvent(homeTeamId, awayTeamId, date))

        }
        Log.d("TAaaaaag","$homeTeamId $awayTeamId $date")
    }

}