package com.cheesecake.presentation.screens.team.teamstatistics

import android.util.Log
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
    teamStatisticsArgs: TeamStatisticsArgs
) : BaseViewModel<TeamStatisticsUiState, TeamStatisticsEvent?>(TeamStatisticsUiState(), Event()) {
    init {
        tryToExecute(
            {
                manageTeamsUseCase.getTeamStatistics(
                    competitionId = teamStatisticsArgs.competitionId,
                    season = teamStatisticsArgs.season,
                    teamId = teamStatisticsArgs.teamId
                )
            },
            ::onSuccess,
            ::onError
        )
    }

    private fun onSuccess(teamStatistics: TeamStatisticsEntity?) {
        teamStatistics?.let { entity ->
            _state.update {
                entity.toUIState().copy(isLoading = false)
            }
        }
    }

    private fun onError(e: Throwable) {
        Log.e("onError: ", e.message.toString())
        _state.update {
            it.copy(
                errorMessage = e.localizedMessage ?: "Unknown error.",
                isLoading = false
            )
        }
    }
}