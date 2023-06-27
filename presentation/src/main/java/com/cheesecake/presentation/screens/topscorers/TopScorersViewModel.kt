package com.cheesecake.presentation.screens.topscorers

import android.util.Log
import com.cheesecake.domain.usecases.GetTeamsStandingByLeagueIdAndSeasonUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class TopScorersViewModel @Inject constructor(
    private val getTeamsStandingByLeagueIdAndSeasonUseCase: GetTeamsStandingByLeagueIdAndSeasonUseCase,
  //  teamsStandingArgs: TeamsStandingArgs
) : BaseViewModel<TopScorersUiState, TopScorersNavigationEvent>(TopScorersUiState(), Event()) {

    fun onError(error: Throwable) {
        Log.e("onTopScorersSuccess", error.message.toString())
        _state.update { it.copy(errorMessage = error.toString(), isLoading = false) }
    }

    private fun onBackClick() {
        _event.update { Event(TopScorersNavigationEvent.NavigateBack) }
    }
}