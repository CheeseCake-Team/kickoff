package com.cheesecake.presentation.screens.standings

import com.cheesecake.domain.entity.TeamStanding
import com.cheesecake.domain.usecases.ManageTeamsUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class StandingsViewModel @Inject constructor(
    private val manageTeamsUseCase: ManageTeamsUseCase,
    private val teamsStandingArgs: TeamsStandingArgs
) : BaseViewModel<StandingsUiState, StandingNavigationEvent>(StandingsUiState(), Event()) {
    init {
        getData()
    }

    private fun onGettingTeamsStandingSuccess(teamsStanding: List<TeamStanding>) {
        _state.update { standingUIState ->
            standingUIState.copy(
                data = teamsStanding.toUiState(),
                isLoading = false,
            )
        }
    }

    fun onBackClick() {
        _event.update { Event(StandingNavigationEvent.NavigateBack) }
    }

    override fun getData() {
        tryToExecute(
            {
                manageTeamsUseCase.getTeamStandingByCompetitionIdAndSeason(
                    teamsStandingArgs.competitionId, teamsStandingArgs.season
                )
            }, ::onGettingTeamsStandingSuccess
        )
    }
}