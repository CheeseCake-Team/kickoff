package com.cheesecake.ui.ui.leagueTeams

import android.util.Log
import com.cheesecake.domain.entity.Team
import com.cheesecake.ui.mapper.toUIModel
import com.cheesecake.domain.usecases.GetAllTeamsInLeagueWithSeasonUseCase
import com.cheesecake.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LeagueTeamsViewModel @Inject constructor(
    private val getAllTeamsInLeagueWithSeasonUseCase: GetAllTeamsInLeagueWithSeasonUseCase
) : BaseViewModel<LeagueTeamsUIState>() {

    override val uiState = LeagueTeamsUIState()

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
                teamUIState.copy(data = list.map { it.toUIModel() }, isLoading = false)
            }
        }
    }

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(isError = e.message.toString())
        }
    }

}