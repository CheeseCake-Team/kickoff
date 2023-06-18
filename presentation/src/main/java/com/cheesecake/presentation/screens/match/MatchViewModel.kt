package com.cheesecake.presentation.screens.match

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.usecases.GetMatchDetailsUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchViewModel
@Inject constructor(
    private val getMatchDetailsUseCase: GetMatchDetailsUseCase,
) : BaseViewModel<MatchUIState, MatchEvents>(MatchUIState(), Event()) {

    init {
        getMatch()
    }

    private fun getMatch() {
        viewModelScope.launch {
            getMatchDetailsUseCase("33-34", "2022-10-16", "Africa/Cairo").let { match ->
                _state.update { uiState ->
                    uiState.copy(
                        homeTeamName = match.homeTeamName,
                        homeTeamLogoUrl = match.homeTeamLogoUrl,
                        homeTeamGoals = match.homeTeamGoals,
                        awayTeamName = match.awayTeamName,
                        awayTeamLogoUrl = match.awayTeamLogoUrl,
                        awayTeamGoals = match.awayTeamGoals,
                        matchState = match.matchState
                    )
                }
            }
        }
    }

}