package com.cheesecake.presentation.screens.match.statistics

import androidx.lifecycle.SavedStateHandle
import com.cheesecake.domain.entity.FixtureStatistics
import com.cheesecake.domain.entity.StatisticsType
import com.cheesecake.domain.entity.getAwayTeamPercentage
import com.cheesecake.domain.entity.getHomeTeamPercentage
import com.cheesecake.domain.usecases.ManageMatchesUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MatchStatisticsViewModel @Inject constructor(
    private val manageMatchesUseCase: ManageMatchesUseCase,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<MatchStatisticsUiState, MatchStatisticsEvents>(
    MatchStatisticsUiState(),
    Event()
) {
    private val matchStatisticsArgs = MatchStatisticsArgs(savedStateHandle)
    val matchState = matchStatisticsArgs.state

    init {
        getData()
    }

    private fun onSuccess(statistics: List<FixtureStatistics>) {
        _isLoading.update { false }
        _errorUiState.update { null }
        _state.update {
            it.copy(
                statisticsItem = statistics.toUIState(),
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

    override fun getData() {
        _isLoading.update { true }
        _errorUiState.update { null }
        tryToExecute(
            { manageMatchesUseCase.getMatchStatisticsByMatchId(matchStatisticsArgs.fixtureId) },
            ::onSuccess,
        )
    }
}