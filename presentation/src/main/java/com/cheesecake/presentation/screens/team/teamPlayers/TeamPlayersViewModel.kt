package com.cheesecake.presentation.screens.team.teamPlayers

import com.cheesecake.domain.entity.SquadPlayer
import com.cheesecake.domain.usecases.GetTeamSquadByIdUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.mapIt
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TeamPlayersViewModel @Inject constructor(
    private val getTeamSquadByIdUseCase: GetTeamSquadByIdUseCase,
    private val teamPlayersArgs: TeamPlayersArgs
) : BaseViewModel<TeamPlayersUiState, TeamPLayerNavigationEvent>(TeamPlayersUiState(), Event()) {
    init {
        tryToExecute(
            { getTeamSquadByIdUseCase(teamPlayersArgs.teamId) },
            ::onGettingTeamSquadSuccess,
            ::onError
        )
    }

    private fun onGettingTeamSquadSuccess(result: List<Pair<String, List<SquadPlayer>>>) {
        _state.update { teamPlayersUiState ->
            teamPlayersUiState.copy(data = result.map { pair ->
                Pair(pair.first, pair.second.map { squad ->
                    squad.mapIt {
                        onClick(squad.id)
                    }
                }
                )
            }, isLoading = false)
        }
    }

    private fun onClick(playerId: Int) {
        _event.update {
            Event(
                TeamPLayerNavigationEvent.NavigateToPlayer(
                    playerId,
                    teamPlayersArgs.season
                )
            )
        }
    }

    private fun onError(error: Throwable) {
        _state.update { it.copy(errorMessage = error.message.toString(), isLoading = false) }
    }
}