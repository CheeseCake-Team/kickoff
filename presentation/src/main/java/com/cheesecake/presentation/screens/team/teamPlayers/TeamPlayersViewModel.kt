package com.cheesecake.presentation.screens.team.teamPlayers

import com.cheesecake.domain.entity.SquadPlayer
import com.cheesecake.domain.usecases.ManagePlayersUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.mapIt
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TeamPlayersViewModel @Inject constructor(
    private val managePlayersUseCase: ManagePlayersUseCase,
    private val teamPlayersArgs: TeamPlayersArgs
) : BaseViewModel<TeamPlayersUiState, TeamPLayerNavigationEvent>(TeamPlayersUiState(), Event()) {
    init {
        getData()
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

    override fun getData() {
        tryToExecute(
            { managePlayersUseCase.getTeamPlayersByTeamId(teamPlayersArgs.teamId) },
            ::onGettingTeamSquadSuccess,
        )
    }
}