package com.cheesecake.presentation.screens.league.leagueTeams

import android.util.Log
import com.cheesecake.domain.entity.Team
import com.cheesecake.presentation.mapper.toTeamUIState
import com.cheesecake.domain.usecases.GetAllTeamsInLeagueWithSeasonUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LeagueTeamsViewModel @Inject constructor(
    private val getAllTeamsInLeagueWithSeasonUseCase: GetAllTeamsInLeagueWithSeasonUseCase
) : BaseViewModel<LeagueTeamsUIState,LeagueTeamsEvent>(LeagueTeamsUIState(), Event()) {

    init {
        getData()
    }

    private fun getData() {
        tryToExecute(
            { getAllTeamsInLeagueWithSeason() },
            ::onSuccess,
            ::onError
        )
    }

    private suspend fun getAllTeamsInLeagueWithSeason() =
        getAllTeamsInLeagueWithSeasonUseCase(39, 2022)


    private fun onSuccess(result: List<Team>) {
        result.let { list ->
            _state.update { teamUIState ->
                Log.i("getData: ", list.toString())
                teamUIState.copy(data = list.map { it.toTeamUIState { onTeamClick(it.id) } }, isLoading = false)
            }
        }
    }

    private fun onTeamClick(teamId: Int) {

    }

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(isError = e.message.toString())
        }
    }

}