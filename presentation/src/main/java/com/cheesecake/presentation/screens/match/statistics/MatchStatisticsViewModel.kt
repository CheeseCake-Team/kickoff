package com.cheesecake.presentation.screens.match.statistics

import androidx.lifecycle.SavedStateHandle
import com.cheesecake.domain.entity.FixtureStatistics
import com.cheesecake.domain.entity.getAwayTeamPercentage
import com.cheesecake.domain.entity.getHomeTeamPercentage
import com.cheesecake.domain.usecases.GetFixtureStatisticsByFixtureIdUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class MatchStatisticsViewModel @Inject constructor(
    private val getFixtureStatisticsByFixtureId: GetFixtureStatisticsByFixtureIdUseCase,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<MatchStatisticsUIState, MatchStatisticsEvents>(
    MatchStatisticsUIState(),
    Event()
) {
    private val matchStatisticsArgs = MatchStatisticsArgs(savedStateHandle)

    init {
        tryToExecute(
            { getFixtureStatisticsByFixtureId(matchStatisticsArgs.fixtureId) },
            ::onSuccess,
            ::onError
        )
    }

    private fun onSuccess(statistics: List<FixtureStatistics>) {
        _state.update { ms ->
            ms.copy(statisticsItem = statistics.map { fixtureStatistics ->
                StatisticsItemUiState(
                    homeTeamValue = fixtureStatistics.homeTeamValue,
                    awayTeamValue = fixtureStatistics.awayTeamValue,
                    typeValue = fixtureStatistics.type,
                    homeTeamPercentage = fixtureStatistics.getHomeTeamPercentage(),
                    awayTeamPercentage = fixtureStatistics.getAwayTeamPercentage()
                )
            })
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



