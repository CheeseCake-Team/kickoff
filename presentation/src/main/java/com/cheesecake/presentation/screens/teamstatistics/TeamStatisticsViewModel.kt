package com.cheesecake.presentation.screens.teamstatistics

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.entity.TeamStatisticsEntity
import com.cheesecake.domain.usecases.GetTeamStatisticsUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toUIState
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class TeamStatisticsViewModel @Inject constructor(
    private val getTeamStatisticsUseCase: GetTeamStatisticsUseCase
) : BaseViewModel<TeamStatisticsUIState, TeamStatisticsEvent?>(TeamStatisticsUIState(), Event()) {

    init {
        tryToExecute(
            { getTeamStatisticsUseCase(leagueId = 39, season = 2022, teamId = 39) },
            ::onSuccess,
            ::onError
        )
    }

    private fun onSuccess(teamStatistics: TeamStatisticsEntity?) {
        teamStatistics?.let {
            val uiState = state.value.copy(
                homePlayed = it.played.home,
                homeWins = it.wins.home,
                homeLoses = it.loses.home,
                homeCleanSheet = it.cleanSheet.home,
                homeFailed = it.failedToScore.home,
                homeGoalsFor = it.goalsFor.home,
                homeGoalsAgainst = it.goalsAgainst.home,
                awayPlayed = it.played.away,
                awayWins = it.wins.away,
                awayLoses = it.loses.away,
                awayCleanSheet = it.cleanSheet.away,
                awayFailed = it.failedToScore.away,
                awayGoalsFor = it.goalsFor.away,
                awayGoalsAgainst = it.goalsAgainst.away,
                totalPlayed = it.played.total,
                totalWins = it.wins.total,
                totalLoses = it.loses.total,
                totalCleanSheet = it.cleanSheet.total,
                totalFailed = it.failedToScore.total,
                totalGoalsFor = it.goalsFor.total,
                totalGoalsAgainst = it.goalsAgainst.total,
                isLoading = false
            )
            _state.value = uiState
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