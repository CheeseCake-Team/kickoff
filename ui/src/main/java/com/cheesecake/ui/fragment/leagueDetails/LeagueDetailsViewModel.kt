package com.cheesecake.ui.fragment.leagueDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.usecases.GetCurrentRoundByLeagueIdAndSeasonUseCase
import com.cheesecake.domain.usecases.GetLeagueByIdAndSeasonUseCase
import com.cheesecake.domain.usecases.GetTeamsStandingByLeagueIdAndSeasonUseCase
import com.cheesecake.domain.usecases.GetTopScorersByLeagueIdAndSeasonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeagueDetailsViewModel @Inject constructor(
    private val getCurrentRoundByLeagueIdAndSeason: GetCurrentRoundByLeagueIdAndSeasonUseCase,
    private val getTeamsStandingByLeagueIdAndSeasonUseCase: GetTeamsStandingByLeagueIdAndSeasonUseCase,
    private val getTopScorersByLeagueIdAndSeason: GetTopScorersByLeagueIdAndSeasonUseCase,
    private val getLeagueByLeagueIdAndSeasonUseCase: GetLeagueByIdAndSeasonUseCase
): ViewModel() {

    private val _leagueDetailsUIState = MutableStateFlow(LeagueDetailsUIState())
    val leagueDetailsUIState = _leagueDetailsUIState.asStateFlow()

    init {
        getLeague()
        getCurrentRound()
        getTeamStanding()
        getTopScorers()
    }

    private fun getLeague() {
        viewModelScope.launch {
            getLeagueByLeagueIdAndSeasonUseCase(39, 2022).let { league ->
                _leagueDetailsUIState.update { it.copy(country = league.country) }
            }
        }
    }

    private fun getTopScorers() {
        viewModelScope.launch {
            getTopScorersByLeagueIdAndSeason(39, 2022).let { scorers ->
                _leagueDetailsUIState.update { it.copy(topPlayers = scorers.take(7), isLoading = false) }
            }
        }
    }

    private fun getTeamStanding() {
        viewModelScope.launch {
            getTeamsStandingByLeagueIdAndSeasonUseCase(39, 2022).let { standings ->
                _leagueDetailsUIState.update {
                    it.copy(
                        teamsStanding = standings.take(4),
                        teamsCount = standings.size.toString(),
                        isLoading = false
                    )
                }
            }
        }
    }

    private fun getCurrentRound() {
        viewModelScope.launch {
            getCurrentRoundByLeagueIdAndSeason(39, 2022).apply {
                _leagueDetailsUIState.update {  it.copy(round = this) }
            }
        }
    }

}