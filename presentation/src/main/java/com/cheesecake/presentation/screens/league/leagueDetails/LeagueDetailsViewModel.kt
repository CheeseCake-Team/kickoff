package com.cheesecake.presentation.screens.league.leagueDetails

import com.cheesecake.domain.usecases.GetCurrentRoundByLeagueIdAndSeasonUseCase
import com.cheesecake.domain.usecases.GetLeagueByIdAndSeasonUseCase
import com.cheesecake.domain.usecases.GetTeamsStandingByLeagueIdAndSeasonUseCase
import com.cheesecake.domain.usecases.GetTopScorersByLeagueIdAndSeasonUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LeagueDetailsViewModel @Inject constructor(
    private val getCurrentRoundByLeagueIdAndSeason: GetCurrentRoundByLeagueIdAndSeasonUseCase,
    private val getTeamsStandingByLeagueIdAndSeasonUseCase: GetTeamsStandingByLeagueIdAndSeasonUseCase,
    private val getTopScorersByLeagueIdAndSeason: GetTopScorersByLeagueIdAndSeasonUseCase,
    private val getLeagueByLeagueIdAndSeasonUseCase: GetLeagueByIdAndSeasonUseCase,
) : BaseViewModel<LeagueDetailsUIState,LeagueDetailsEvents>(LeagueDetailsUIState(), Event()) {

    private val _leagueDetailsUIState = MutableStateFlow(LeagueDetailsUIState())
    val leagueDetailsUIState = _leagueDetailsUIState.asStateFlow()

    init {
        getLeague()
        getCurrentRound()
        getTeamStanding()
        getTopScorers()
    }


    private fun getLeague() {
        tryToExecute(
            {
                getLeagueByLeagueIdAndSeasonUseCase(39, 2022)
            },
            { league ->

                _leagueDetailsUIState.update { it.copy(country = league.country) }
            },
            { error ->
                _leagueDetailsUIState.update { it.copy( error.message.toString(), isLoading = false) }


            }
        )
    }


    private fun getTopScorers() {
        tryToExecute(
            { getTopScorersByLeagueIdAndSeason(39, 2022) },
            { scorers ->
                _leagueDetailsUIState.update {
                    it.copy(
                        topPlayers = scorers.take(7),
                        isLoading = false
                    )
                }
            },
            { error ->
                _leagueDetailsUIState.update { it.copy( error.message.toString(), isLoading = false) }

            }
        )
    }


    private fun getTeamStanding() {
        tryToExecute(
            {
                getTeamsStandingByLeagueIdAndSeasonUseCase(39, 2022)
            },
            { standings ->
                _leagueDetailsUIState.update {
                    it.copy(
                        teamsStanding = standings.take(4),
                        teamsCount = standings.size.toString(),
                        isLoading = false
                    )
                }
            },
            { error ->
                _leagueDetailsUIState.update { it.copy( error.message.toString(), isLoading = false) }

            }
        )
    }


    private fun getCurrentRound() {
        tryToExecute(
            {
                getCurrentRoundByLeagueIdAndSeason(39, 2022)
            },
            { round ->
                _leagueDetailsUIState.update { it.copy(round = round) }
            },
            { error ->
                _leagueDetailsUIState.update { it.copy( error.message.toString(), isLoading = false) }

            }
        )
    }


}