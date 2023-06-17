package com.cheesecake.presentation.screens.match

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.usecases.GetMatchDetailsUseCase
import com.cheesecake.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchViewModel
@Inject constructor(
    private val GetMatchDetailsUseCase: GetMatchDetailsUseCase,
) : BaseViewModel<MatchUIState>(MatchUIState()) {

    init {
        getMatch()
    }


    private fun getMatch() {
        viewModelScope.launch {
            GetMatchDetailsUseCase("33-34", 2022, "Africa/Cairo").let { match ->
                Log.i("Mujtaba", "getMatch: ${match}")
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
                Log.i("Mujtaba", "getMatch: ${_state.value}")}
        }
    }

}