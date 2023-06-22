package com.cheesecake.presentation.screens.match

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
    matchArgs: MatchNavigationArgs
) : BaseViewModel<MatchUIState, MatchEvents>(MatchUIState(), Event()) {

    private val _args = MutableLiveData<Args>()
    val args: LiveData<Args> = _args

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
                matchState = match.matchState
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

}

data class Args(
    val fixtureId: Int = 0,
    val homeTeamId: Int = 0,
    val awayTeamId: Int = 0
)