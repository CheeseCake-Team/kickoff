package com.cheesecake.presentation.screens.match.statistics

import androidx.lifecycle.viewModelScope
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
) : BaseViewModel<MatchStatisticsUIState, MatchStatisticsEvents>(MatchStatisticsUIState(), Event()) {

    init {
        getFixtureStatisticsByFixtureId
        viewModelScope.launch {
            getFixtureStatisticsByFixtureId(215662).let {
                _state.update { ms ->
                    ms.copy(statisticsItem = it.map { fixtureStatistics ->
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
        }
    }
}



