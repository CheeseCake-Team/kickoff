package com.cheesecake.presentation.screens.team.teamstatistics

import com.cheesecake.domain.entity.TeamStatisticsEntity
import com.cheesecake.domain.usecases.GetTeamStatisticsUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class TeamStatisticsViewModel @Inject constructor(
    private val getTeamStatisticsUseCase: GetTeamStatisticsUseCase,
    teamStatisticsArgs:TeamStatisticsArgs
) : BaseViewModel<TeamStatisticsUIState, TeamStatisticsEvent?>(TeamStatisticsUIState(), Event()) {

    init {
        tryToExecute(
            { getTeamStatisticsUseCase(leagueId = 39, season = 2022, teamId = teamStatisticsArgs.teamId) },
            ::onSuccess,
            ::onError
        )
    }

    private fun onSuccess(teamStatistics: TeamStatisticsEntity?) {
        teamStatistics?.let {entity->
            _state.update {
                entity.toUIState().copy(isLoading = false)
            }
        }
    }

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(
                errorMessage = e.localizedMessage ?: "Unknown error.",
                isLoading = false
            )

        }
    }

}