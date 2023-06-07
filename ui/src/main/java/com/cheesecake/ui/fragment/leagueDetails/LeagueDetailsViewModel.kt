package com.cheesecake.ui.fragment.leagueDetails

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.usecases.GetCurrentRoundByLeagueIdAndSeason
import com.cheesecake.domain.usecases.GetTeamsStandingByLeagueIdAndSeasonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeagueDetailsViewModel @Inject constructor(
    private val getCurrentRoundByLeagueIdAndSeason: GetCurrentRoundByLeagueIdAndSeason,
    private val getTeamsStandingByLeagueIdAndSeasonUseCase: GetTeamsStandingByLeagueIdAndSeasonUseCase
): ViewModel() {

    private val _leagueDetailsUIState = MutableStateFlow(LeagueDetailsUIState())
    val leagueDetailsUIState = _leagueDetailsUIState.asStateFlow()

    init {
        getCurrentRound()
        getTeamStanding()
    }

    private fun getTeamStanding() {
        viewModelScope.launch {
            getTeamsStandingByLeagueIdAndSeasonUseCase(39, 2022).let { standingList ->
                _leagueDetailsUIState.update {
                    Log.i("dsaf", standingList.toString())
                    it.copy(
                        teamsStanding = standingList.take(4), isLoading = false
                    )
                }
            }
        }
    }

    private fun getCurrentRound() {
        viewModelScope.launch {
            getCurrentRoundByLeagueIdAndSeason(39, 2022).apply {
                _leagueDetailsUIState.update {
                    it.copy(
                        round = this
                    )
                }
            }

        }
    }

}