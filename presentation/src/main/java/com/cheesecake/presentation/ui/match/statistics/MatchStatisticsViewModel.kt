package com.cheesecake.presentation.ui.match.statistics

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.usecases.GetFixtureStatisticsByFixtureIdUseCase
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MatchStatisticsViewModel @Inject constructor(
    private val getFixtureStatisticsByFixtureId: GetFixtureStatisticsByFixtureIdUseCase,
) : BaseViewModel<MatchStatisticsUIState>(MatchStatisticsUIState()) {

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
                            homeTeamPercentage = fixtureStatistics.homeTeamPercentage,
                            awayTeamPercentage = fixtureStatistics.awayTeamPercentage

                        )
                    })
                }

            }


        }
    }


}



