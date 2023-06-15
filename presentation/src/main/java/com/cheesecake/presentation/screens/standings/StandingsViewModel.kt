package com.cheesecake.presentation.screens.standings

import android.util.Log
import com.cheesecake.domain.entity.TeamStanding
import com.cheesecake.domain.usecases.GetTeamsStandingByLeagueIdAndSeasonUseCase
import com.cheesecake.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class StandingsViewModel @Inject constructor(
    private val getTeamsStandingByLeagueIdAndSeasonUseCase: GetTeamsStandingByLeagueIdAndSeasonUseCase
) : BaseViewModel<StandingsUiState>(StandingsUiState()){

    init {
        getData()
    }

    private fun getData() {
        tryToExecute(
          ::getTeamsStanding,
          ::onSuccess,
          ::onError,
        )
    }

    private suspend fun getTeamsStanding() = getTeamsStandingByLeagueIdAndSeasonUseCase(20 , 2023)

    private fun onSuccess(result: List<TeamStanding>){
        result.let {list ->
            _state.update { standingsUiState ->
                Log.i("getData", list.toString())
                standingsUiState.copy(data = list , isLoading = false)
            }
        }
    }

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(errorMessage = e.message.toString())
        }
    }
}