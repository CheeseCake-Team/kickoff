package com.cheesecake.presentation.screens.match.statistics

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.FixtureStatistics
import com.cheesecake.domain.entity.StatisticsType
import com.cheesecake.domain.entity.getAwayTeamPercentage
import com.cheesecake.domain.entity.getHomeTeamPercentage
import com.cheesecake.domain.usecases.GetFixtureStatisticsByFixtureIdUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
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
    val matchState = matchStatisticsArgs.state

    init {
        tryToExecute(
            { getFixtureStatisticsByFixtureId(matchStatisticsArgs.fixtureId) },
            ::onSuccess,
            ::onError
        )
    }

    private fun onSuccess(statistics: List<FixtureStatistics>) {
        _state.update { ms ->
            ms.copy(
                statisticsItem = statistics.toUIState(),
                isLoading = false,
                noData = statistics.isEmpty()

            )
        }
    }

    private fun List<FixtureStatistics>.toUIState(): List<StatisticsItemUiState> =
        map { fixtureStatistics ->
            val type: String = when (fixtureStatistics.statisticsType) {
                StatisticsType.ACCURATE_PASSES -> "Accurate Passes"
                StatisticsType.ACCURATE_PASSES_PERCENTAGE -> "Passes Accuracy %"
                StatisticsType.EXPECTED_GOALS -> "Expected Goals"
                else -> fixtureStatistics.type
            }
            val homeTeamPercentage: Int = when (fixtureStatistics.statisticsType) {
                StatisticsType.ACCURATE_PASSES_PERCENTAGE -> fixtureStatistics.homeTeamValue
                else -> fixtureStatistics.getHomeTeamPercentage()
            }
            val awayTeamPercentage: Int = when (fixtureStatistics.statisticsType) {
                StatisticsType.ACCURATE_PASSES_PERCENTAGE -> fixtureStatistics.awayTeamValue
                else -> fixtureStatistics.getAwayTeamPercentage()
            }
            StatisticsItemUiState(
                homeTeamValue = fixtureStatistics.homeTeamValue,
                awayTeamValue = fixtureStatistics.awayTeamValue,
                typeValue = type,
                statisticsType = fixtureStatistics.statisticsType,
                homeTeamPercentage = homeTeamPercentage,
                awayTeamPercentage = awayTeamPercentage
            )
        }

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(
                errorMessage = e.localizedMessage ?: "Unknown error.",
                isLoading = false,
                noData = true


                )
        }
    }


}



