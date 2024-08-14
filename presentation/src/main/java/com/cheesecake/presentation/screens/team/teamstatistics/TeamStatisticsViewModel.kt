package com.cheesecake.presentation.screens.team.teamstatistics

import com.cheesecake.domain.entity.TeamStatisticsEntity
import com.cheesecake.domain.usecases.ManageTeamsUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TeamStatisticsViewModel @Inject constructor(
    private val manageTeamsUseCase: ManageTeamsUseCase,
    private val teamStatisticsArgs: TeamStatisticsArgs
) : BaseViewModel<TeamStatisticsUiState, TeamStatisticsEvent?>(TeamStatisticsUiState(), Event()) {
    init {
        getData()
    }

    override fun getData() {
        _isLoading.update { true }
        _errorUiState.update { null }
        tryToExecute(
            {
                manageTeamsUseCase.getTeamStatistics(
                    competitionId = teamStatisticsArgs.competitionId,
                    season = teamStatisticsArgs.season,
                    teamId = teamStatisticsArgs.teamId
                )
            },
            ::onSuccess,
        )
    }

    private fun onSuccess(teamStatistics: TeamStatisticsEntity?) {
        _isLoading.update { false }
        _errorUiState.update { null }
        teamStatistics?.let { entity -> _state.update { entity.toUIState() } }
    }
}