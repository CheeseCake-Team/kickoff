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
    private val getTeamMatchesByTeamIdAndSeasonUseCase: GetTeamMatchesByTeamIdAndSeasonUseCase,
    teamMatchesArgs: TeamMatchesArgs
) : BaseViewModel<TeamMatchesUiState, TeamMatchesNavigationEvent>(TeamMatchesUiState(), Event()) {
    init {
        tryToExecute(
            {
                getTeamMatchesByTeamIdAndSeasonUseCase(
                    "Africa/Cairo", teamMatchesArgs.teamId, teamMatchesArgs.season
                )
            }, ::onSuccess, ::onError
        )
    }

    private fun onSuccess(fixtures: List<Fixture>) {
        _state.update {
            it.copy(
                data = fixtures.toUiState(::onMatchClicked, ::onCompetitionClicked),
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
    }

    private fun onCompetitionClicked(competitionId: Int, season: Int) {
        _event.update {
            Event(TeamMatchesNavigationEvent.CompetitionClickedEvent(competitionId, season))
        }
    }
}