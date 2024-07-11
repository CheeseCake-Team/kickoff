package com.cheesecake.presentation.screens.competition.competitiondetails

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.entity.PlayerStatistics
import com.cheesecake.domain.entity.TeamStanding
import com.cheesecake.domain.usecases.GetTeamsStandingByLeagueIdAndSeasonUseCase
import com.cheesecake.domain.usecases.ManageCompetitionsUseCase
import com.cheesecake.domain.usecases.ManagePlayersUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import com.cheesecake.presentation.screens.competition.CompetitionArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CompetitionDetailsViewModel @Inject constructor(
    private val getTeamsStandingByCompetitionIdAndSeasonUseCase: GetTeamsStandingByLeagueIdAndSeasonUseCase,
    private val managePlayersUseCase: ManagePlayersUseCase,
    private val manageCompetitionsUseCase: ManageCompetitionsUseCase,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<CompetitionDetailsUiState, CompetitionDetailsEvents>(
    CompetitionDetailsUiState(),
    Event()
) {
    private val competitionArgs = CompetitionArgs(savedStateHandle)

    init {
        tryToExecute(
            {
                manageCompetitionsUseCase.getCompetitionById(competitionArgs.competitionId)
            }, ::onGettingCompetitionSuccess, ::onError
        )
        tryToExecute(
            {
                manageCompetitionsUseCase.getCurrentRoundByIdAndSeason(
                    competitionArgs.competitionId,
                    competitionArgs.season
                )
            },
            ::onGettingRoundSuccess, ::onError,
        )
        tryToExecute(
            {
                getTeamsStandingByCompetitionIdAndSeasonUseCase(
                    competitionArgs.competitionId,
                    competitionArgs.season
                )
            }, ::onGettingTeamsStandingSuccess, ::onError
        )
        tryToExecute(
            {
                managePlayersUseCase.getTopScorersInCompetition(
                    competitionArgs.competitionId,
                    competitionArgs.season
                )
            }, ::onGettingTopScorersSuccess, ::onError
        )
    }

    private fun onGettingTopScorersSuccess(playersStatistics: List<PlayerStatistics>) {
        _state.update { competitionDetailsUiState ->
            competitionDetailsUiState.copy(
                topPlayers = playersStatistics.toUiState().takeIf { it.isNotEmpty() }?.take(7)
                    ?: emptyList(),
                isTopPlayersEmpty = playersStatistics.isEmpty(),
                isLoading = false,
            )
        }
    }

    private fun onGettingRoundSuccess(round: String) {
        _state.update { it.copy(round = round) }
    }

    private fun onGettingCompetitionSuccess(competition: League) {
        _state.update { it.copy(countryName = competition.countryName) }
    }

    private fun onGettingTeamsStandingSuccess(standings: List<TeamStanding>) {
        _state.update { competitionDetailsUiState ->
            competitionDetailsUiState.copy(
                teamsStanding = standings.toUiState().take(4),
                teamsCount = standings.size.toString(),
                isTeamsStandingEmpty = standings.isEmpty(),
                isLoading = false
            )
        }
    }

    private fun onError(throwable: Throwable) {
        Log.e("onError: ", throwable.localizedMessage ?: "Unknown error")
        _state.update {
            it.copy(
                errorMessage = throwable.localizedMessage ?: "Unknown error",
                isLoading = false
            )
        }
    }

    fun onStandingSeeAllClick() {
        _event.update {
            Event(
                CompetitionDetailsEvents.NavigateToTeamsStanding(
                    competitionArgs.competitionId,
                    competitionArgs.season
                )
            )
        }
    }

    fun onTopScorerClick() {
        _event.update {
            Event(
                CompetitionDetailsEvents.NavigateToTopPlayer(
                    competitionArgs.competitionId,
                    competitionArgs.season
                )
            )
        }
    }
}