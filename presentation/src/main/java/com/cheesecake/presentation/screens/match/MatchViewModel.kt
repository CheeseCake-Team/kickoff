package com.cheesecake.presentation.screens.match

import android.util.Log
import com.cheesecake.domain.entity.Match
import com.cheesecake.domain.usecases.GetMatchDetailsUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MatchViewModel
@Inject constructor(
    private val getMatchDetailsUseCase: GetMatchDetailsUseCase,
    matchArgs: MatchArgs
) : BaseViewModel<MatchUIState, MatchEvents>(MatchUIState(), Event()) {


    private val _matchId: MutableStateFlow<String> = MutableStateFlow(matchArgs.matchId)
    val matchId: StateFlow<String> get() = _matchId

    private val _fixtureId: MutableStateFlow<Int?> = MutableStateFlow(null)
    val fixtureId: StateFlow<Int?> get() = _fixtureId

    init {
        tryToExecute(
            { getMatchDetailsUseCase(matchArgs.matchId,matchArgs.date, "Africa/Cairo") },
            ::onSuccess,
            ::onError
        )
    }

    private fun onSuccess(match: Match) {
        _state.update { uiState ->
            uiState.copy(
                homeTeamName = match.homeTeamName,
                matchId = match.matchId,
                homeTeamLogoUrl = match.homeTeamLogoUrl,
                homeTeamGoals = match.homeTeamGoals,
                awayTeamName = match.awayTeamName,
                awayTeamLogoUrl = match.awayTeamLogoUrl,
                awayTeamGoals = match.awayTeamGoals,
                matchState = match.matchState
            )
        }
        _fixtureId.value = match.fixtureId
    }

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(
                errorMessage = e.localizedMessage ?: "Unknown error.",
                isLoading = false
            )
        }

    }

}