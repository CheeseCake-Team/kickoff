package com.cheesecake.presentation.screens.team.teamPlayers

import com.cheesecake.domain.entity.SquadPlayer
import com.cheesecake.domain.usecases.GetTeamSquadByIdUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject
@HiltViewModel
class TeamPlayersViewModel @Inject constructor(
    private val getTeamSquadByIdUseCase: GetTeamSquadByIdUseCase
) :
    BaseViewModel<TeamPlayersUIState, TeamPLayerNavigationEvent>(TeamPlayersUIState(), Event()){

    init {
        getData()
    }

    private fun getData() {
        tryToExecute(
            { getTeamSquadByIdUseCase(34) },
            ::onSuccess,
            ::onError
        )
    }

    private fun onSuccess(result: List<Pair<String, List<SquadPlayer>>>) {
        _state.update { it.copy(data = result, isLoading = false) }
    }

    private fun onError(error: Throwable) {
        _state.update { it.copy(errorMessage = error.message.toString(), isLoading = false) }
    }

}