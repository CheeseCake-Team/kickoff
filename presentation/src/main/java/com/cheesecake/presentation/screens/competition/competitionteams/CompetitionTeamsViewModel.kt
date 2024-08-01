package com.cheesecake.presentation.screens.competition.competitionteams

import androidx.lifecycle.SavedStateHandle
import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.usecases.ManageTeamsUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import com.cheesecake.presentation.screens.competition.CompetitionArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CompetitionTeamsViewModel @Inject constructor(
    private val manageTeamsUseCase: ManageTeamsUseCase,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<CompetitionTeamsUiState, CompetitionTeamsEvent>(
    CompetitionTeamsUiState(),
    Event()
) {
    private val competitionArgs = CompetitionArgs(savedStateHandle)

    init {
        getData()
    }

    private fun onSuccess(teams: List<Team>) {
        _state.update { teamUIState ->
            teamUIState.copy(data = teams.toUiState(::onTeamClicked), isLoading = false)
        }
    }

    override fun getData() {
        tryToExecute(
            {
                manageTeamsUseCase.getCompetitionTeams(
                    competitionArgs.competitionId,
                    competitionArgs.season
                )
            },
            ::onSuccess,
        )
    }

    private fun onTeamClicked(teamId: Int) {
        _event.update {
            Event(
                CompetitionTeamsEvent.TeamClickEvent(
                    teamId,
                    competitionArgs.competitionId,
                    competitionArgs.season
                )
            )
        }
    }
}