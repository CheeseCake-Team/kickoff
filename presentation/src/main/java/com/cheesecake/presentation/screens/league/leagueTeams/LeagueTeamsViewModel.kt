package com.cheesecake.presentation.screens.league.leagueTeams

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.cheesecake.domain.entity.Team
import com.cheesecake.presentation.mapper.toUIState
import com.cheesecake.domain.usecases.GetAllTeamsInLeagueWithSeasonUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import com.cheesecake.presentation.screens.league.LeagueArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LeagueTeamsViewModel @Inject constructor(
    private val getAllTeamsInLeagueWithSeasonUseCase: GetAllTeamsInLeagueWithSeasonUseCase,
    savedStateHandle: SavedStateHandle,
    ) : BaseViewModel<LeagueTeamsUIState,LeagueTeamsEvent>(LeagueTeamsUIState(), Event()) {
    private val leagueArg = LeagueArgs(savedStateHandle)

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
        getAllTeamsInLeagueWithSeasonUseCase( leagueArg.leagueId,  leagueArg.season)


    private fun onSuccess(result: List<Team>) {
        result.let { list ->
            _state.update { teamUIState ->
                Log.i("getData: ", list.toString())
                teamUIState.copy(data = list.map { it.toUIState() }, isLoading = false)
            }
        }
    }

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(isError = e.message.toString())
        }
    }

}