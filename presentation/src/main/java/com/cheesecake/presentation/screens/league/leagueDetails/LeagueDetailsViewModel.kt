package com.cheesecake.presentation.screens.league.leagueDetails

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.cheesecake.domain.usecases.GetCurrentRoundByLeagueIdAndSeasonUseCase
import com.cheesecake.domain.usecases.GetLeagueByIdAndSeasonUseCase
import com.cheesecake.domain.usecases.GetTeamsStandingByLeagueIdAndSeasonUseCase
import com.cheesecake.domain.usecases.GetTopScorersByLeagueIdAndSeasonUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import com.cheesecake.presentation.screens.league.LeagueArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LeagueDetailsViewModel @Inject constructor(
    private val getCurrentRoundByLeagueIdAndSeason: GetCurrentRoundByLeagueIdAndSeasonUseCase,
    private val getTeamsStandingByLeagueIdAndSeasonUseCase: GetTeamsStandingByLeagueIdAndSeasonUseCase,
    private val getTopScorersByLeagueIdAndSeason: GetTopScorersByLeagueIdAndSeasonUseCase,
    private val getLeagueByLeagueIdAndSeasonUseCase: GetLeagueByIdAndSeasonUseCase,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<LeagueDetailsUIState, LeagueDetailsEvents>(LeagueDetailsUIState(), Event()) {

    private val leagueArgs = LeagueArgs(savedStateHandle)

    init {
        getLeague(leagueArgs.leagueId,)
        getCurrentRound(leagueArgs.leagueId, leagueArgs.season)
        getTeamStanding(leagueArgs.leagueId, leagueArgs.season)
        getTopScorers(leagueArgs.leagueId, leagueArgs.season)
    }

    private fun getLeague(leagueId: Int,) {
        tryToExecute(
            {
                getLeagueByLeagueIdAndSeasonUseCase(leagueId,)
            },
            { league ->
                _state.update { it.copy(country = league.countryName) }
            },
            { error ->
                _state.update {
                    it.copy(
                        errorMessage = error.localizedMessage ?: "Unknown error",
                        isLoading = false
                    )
                }
            }
        )
    }

    private fun getTopScorers(leagueId: Int, season: Int) {
        tryToExecute(
            { getTopScorersByLeagueIdAndSeason(leagueId, season) },
            { scorers ->
                _state.update { leagueDetailsUIState ->
                    Log.e("getTopScorers: ", scorers.toString())
                    leagueDetailsUIState.copy(
                        topPlayers = scorers.takeIf { it.isNotEmpty() }?.take(7) ?: emptyList(),
                        isTopPlayersEmpty = scorers.isEmpty(),
                        isLoading = false
                    )
                }
            },
            { error ->
                _state.update {
                    Log.e("getTopScorers: ", error.message.toString())
                    it.copy(
                        isTopPlayersEmpty = true,
                        errorMessage = error.localizedMessage ?: "Unknown error",
                        isLoading = false
                    )
                }

            }
        )
    }

    private fun getTeamStanding(leagueId: Int, season: Int) {
        tryToExecute(
            {
                getTeamsStandingByLeagueIdAndSeasonUseCase(leagueId, season)
            },
            { standings ->
                _state.update { leagueDetailsUIState ->
                    Log.e("getTeamStanding: ", standings.toString())
                    leagueDetailsUIState.copy(
                        teamsStanding =  standings.take(4),
                        teamsCount = standings.size.toString(),
                        isTeamsStandingEmpty = standings.isEmpty(),
                        isLoading = false
                    )
                }
            },
            { error ->
                _state.update {
                    Log.e("getTeamStanding: ", error.message.toString())
                    it.copy(
                        isTeamsStandingEmpty = true,
                        errorMessage = error.localizedMessage ?: "Unknown error",
                        isLoading = false
                    )
                }

            }
        )
    }


    private fun getCurrentRound(leagueId: Int, season: Int) {
        tryToExecute(
            {
                getCurrentRoundByLeagueIdAndSeason(leagueId, season)
            },
            { round ->
                _state.update { it.copy(round = round) }
            },
            { error ->
                _state.update {
                    it.copy(
                        errorMessage = error.localizedMessage ?: "Unknown error",
                        isLoading = false
                    )
                }
            }
        )
    }

}