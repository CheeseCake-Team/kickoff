package com.cheesecake.presentation.screens.team.teamMatches

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.usecases.ManageMatchesUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TeamMatchesViewModel @Inject constructor(
    private val manageMatchesUseCase: ManageMatchesUseCase,
    private val teamMatchesArgs: TeamMatchesArgs
) : BaseViewModel<TeamMatchesUiState, TeamMatchesNavigationEvent>(TeamMatchesUiState(), Event()) {
    init {
        getData()
    }

    private fun onSuccess(fixtures: List<Fixture>) {
        _isLoading.update { false }
        _errorUiState.update { null }
        _state.update {
            it.copy(data = fixtures.toUiState(::onMatchClicked, ::onCompetitionClicked))
        }
    }

    override fun getData() {
        _isLoading.update { true }
        _errorUiState.update { null }
        tryToExecute(
            {
                manageMatchesUseCase.getTeamMatchesByTeamIdAndSeason(
                    "Africa/Cairo", teamMatchesArgs.teamId, teamMatchesArgs.season
                )
            }, ::onSuccess
        )
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