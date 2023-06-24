package com.cheesecake.presentation.screens.match

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.Match
import com.cheesecake.domain.usecases.GetMatchDetailsUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchViewModel
@Inject constructor(
    private val getMatchDetailsUseCase: GetMatchDetailsUseCase,
    matchArgs: MatchNavigationArgs
) : BaseViewModel<MatchUIState, MatchEvents>(MatchUIState(), Event()) {

    private val _args = MutableLiveData<Args>()
    val args: LiveData<Args> = _args
    private val _events = MutableSharedFlow<Event<MatchEvents>>()
    val events: SharedFlow<Event<MatchEvents>> = _events

    init {
        tryToExecute(
            {
                getMatchDetailsUseCase(
                    matchArgs.homeTeamId,
                    matchArgs.awayTeamId,
                    matchArgs.date,
                    "Africa/Cairo"
                )
            },
            ::onSuccess,
            ::onError
        )
    }

    private fun onSuccess(match: Match) {
        _state.update { uiState ->
            uiState.copy(
                homeTeamName = match.homeTeamName,
                homeTeamLogoUrl = match.homeTeamLogoUrl,
                homeTeamGoals = match.homeTeamGoals,
                awayTeamName = match.awayTeamName,
                awayTeamLogoUrl = match.awayTeamLogoUrl,
                awayTeamGoals = match.awayTeamGoals,
                matchState = match.matchState,
                onBackClick = { backClicked() }


            )
        }
        Log.d("TAG", "onSuccess match: $match")
        _args.postValue(Args(match.fixtureId, match.homeTeamId, match.awayTeamId))
    }

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(
                errorMessage = e.localizedMessage ?: "Unknown error.",
                isLoading = false

            )
        }

    }

    private fun backClicked() {
        viewModelScope.launch {
            _event.update{Event(MatchEvents.BackClickEvent)}
        }
    }

}

data class Args(
    val fixtureId: Int = 0,
    val homeTeamId: Int = 0,
    val awayTeamId: Int = 0
)