package com.cheesecake.presentation.screens.match

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.Match
import com.cheesecake.domain.usecases.ManageMatchesUseCase
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
    private val manageMatchesUseCase: ManageMatchesUseCase,
    private val matchArgs: MatchNavigationArgs
) : BaseViewModel<MatchUiState, MatchEvents>(MatchUiState(), Event()) {
    private val _args = MutableLiveData<Args>()
    val args: LiveData<Args> = _args
    private val _events = MutableSharedFlow<Event<MatchEvents>>()
    val events: SharedFlow<Event<MatchEvents>> = _events

    init {
        getData()
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
                onBackClick = { backClicked() },
                noData = match.homeTeamName.isEmpty() && match.awayTeamName.isEmpty()
            )
        }
        _args.postValue(Args(match.fixtureId, match.homeTeamId, match.awayTeamId, match.matchState))
    }

    override fun getData() {
        tryToExecute(
            {
                manageMatchesUseCase.getMatchDetails(
                    matchArgs.homeTeamId,
                    matchArgs.awayTeamId,
                    matchArgs.date,
                    "Africa/Cairo"
                )
            },
            ::onSuccess,
        )
    }

    private fun backClicked() {
        viewModelScope.launch {
            _event.update { Event(MatchEvents.onBackClick) }
        }
    }
}

data class Args(
    val fixtureId: Int = 0,
    val homeTeamId: Int = 0,
    val awayTeamId: Int = 0,
    val state: String = ""
)