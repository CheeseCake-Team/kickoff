package com.cheesecake.presentation.screens.topscorers

import android.util.Log
import com.cheesecake.domain.entity.Player
import com.cheesecake.domain.entity.PlayerStatistics
import com.cheesecake.domain.usecases.GetTeamsStandingByLeagueIdAndSeasonUseCase
import com.cheesecake.domain.usecases.GetTopScorersByLeagueIdAndSeasonUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import com.cheesecake.presentation.screens.standings.TeamsStandingArgs
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class TopScorersViewModel @Inject constructor(
    private val getTopScorersByLeagueIdAndSeason: GetTopScorersByLeagueIdAndSeasonUseCase,
    teamsStandingArgs: TeamsStandingArgs
) : BaseViewModel<TopScorersUiState, TopScorersNavigationEvent>(TopScorersUiState(), Event()) {

    init {
        getTopScorers(teamsStandingArgs.leagueId, teamsStandingArgs.season)
    }

    private fun getTopScorers(leagueId: Int, season: Int) {
        tryToExecute(
            { getTopScorersByLeagueIdAndSeason(leagueId, season) },
            { scorers ->
                _state.update { leagueDetailsUIState ->
                    leagueDetailsUIState.copy(
                        data = scorers,
                        isLoading = false,
                        onBackClick = { onBackClick() }
                    )
                }
            },
            { error ->
                _state.update {
                    Log.e("getTopScorers: ", error.message.toString())
                    it.copy(
                        errorMessage = error.localizedMessage ?: "Unknown error",
                        isLoading = false
                    )
                }

            }
        )
    }

    private fun onBackClick() {
        _event.update { Event(TopScorersNavigationEvent.NavigateBack) }
    }

}