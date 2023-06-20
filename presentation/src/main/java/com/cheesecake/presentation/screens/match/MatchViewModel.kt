package com.cheesecake.presentation.screens.match

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.cheesecake.domain.entity.Match
import com.cheesecake.domain.usecases.GetMatchDetailsUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MatchViewModel
@Inject constructor(
    private val getMatchDetailsUseCase: GetMatchDetailsUseCase,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<MatchUIState, MatchEvents>(MatchUIState(), Event()) {

    private val matchArgs = MatchArgs(savedStateHandle)

    private val _fixtureId = MutableLiveData<Int>()
    val fixtureId: LiveData<Int> = _fixtureId

    init {
        getMatch()
    }

    private fun getMatch() {
        tryToExecute(
            { getMatchDetailsUseCase("33-34","2019-12-26", "Africa/Cairo") },
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
        Log.d("TAG", "getMatch:${match.fixtureId} ")
        _fixtureId.postValue(match.fixtureId)

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