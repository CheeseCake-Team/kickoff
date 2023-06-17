package com.cheesecake.presentation.screens.standings

import com.cheesecake.domain.usecases.GetTeamsStandingByLeagueIdAndSeasonUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class StandingsViewModel @Inject constructor(
    private val getTeamsStandingByLeagueIdAndSeasonUseCase: GetTeamsStandingByLeagueIdAndSeasonUseCase
) : BaseViewModel<StandingsUiState , StandingNavigationEvent>(StandingsUiState() , Event()){
    private val _standingUiState = MutableStateFlow(StandingsUiState())
    val standingUiState = _standingUiState.asStateFlow()
    init {
        getTeamStanding()
    }

    private fun getTeamStanding() {
        tryToExecute(
            {
                getTeamsStandingByLeagueIdAndSeasonUseCase(39, 2022)
            },
            { standings ->
                _standingUiState.update {
                    it.copy(
                        data = standings,
                        isLoading = false
                    )
                }
            },
            { error ->
                _standingUiState.update { it.copy( errorMessage = error.toString(), isLoading = false) }

            }
        )
    }
}