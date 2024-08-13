package com.cheesecake.presentation.screens.match

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cheesecake.domain.entity.Match
import com.cheesecake.domain.usecases.ManageMatchesUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MatchViewModel
@Inject constructor(
    private val manageMatchesUseCase: ManageMatchesUseCase,
    private val matchArgs: MatchNavigationArgs
) : BaseViewModel<MatchUiState, MatchEvents>(MatchUiState(), Event()) {
    private val _args = MutableLiveData<Args>()
    val args: LiveData<Args> = _args

    init {
        getData()
    }

    private fun onSuccess(match: Match) {
        _errorUiState.update { null }
        _isLoading.update { false }
        _state.update { uiState ->
            uiState.copy(
                homeTeamName = match.homeTeamName,
                homeTeamLogoUrl = match.homeTeamLogoUrl,
                homeTeamGoals = match.homeTeamGoals.toString(),
                awayTeamName = match.awayTeamName,
                awayTeamLogoUrl = match.awayTeamLogoUrl,
                awayTeamGoals = match.awayTeamGoals.toString(),
                matchState = match.matchState,
                onBackClick = { backClicked() },
            )
        }
        _args.postValue(Args(match.fixtureId, match.homeTeamId, match.awayTeamId, match.matchState))
    }

    override fun getData() {
        _errorUiState.update { null }
        _isLoading.update { true }
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
        _event.update { Event(MatchEvents.NavigateBack) }
    }
}

data class Args(
    val fixtureId: Int = 0,
    val homeTeamId: Int = 0,
    val awayTeamId: Int = 0,
    val state: String = ""
)