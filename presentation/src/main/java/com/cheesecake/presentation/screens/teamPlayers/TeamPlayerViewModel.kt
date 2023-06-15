package com.cheesecake.presentation.screens.teamPlayers

import com.cheesecake.domain.entity.PlayerStatistics
import com.cheesecake.domain.usecases.GetTeamSquadByIdUseCase
import com.cheesecake.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject
@HiltViewModel
class TeamPlayerViewModel@Inject constructor(
    private val getTeamSquadByIdUseCase: GetTeamSquadByIdUseCase) :
    BaseViewModel<TeamPlayerUIState>(TeamPlayerUIState()){

    init {
        getData()
    }
    private fun getData() {
        tryToExecute(
            { getTeamSquadByIdUseCase(78) },
            ::onSuccess,
            ::onError
        )
    }

    private fun onSuccess(result: List<Pair<String, List<PlayerStatistics>>>) {
        _state.update { it.copy(data = result, isLoading = false) }
    }

    private fun onError(error: Throwable) {
        _state.update { it.copy(errorMessage = error.message.toString(), isLoading = false) }
    }

}