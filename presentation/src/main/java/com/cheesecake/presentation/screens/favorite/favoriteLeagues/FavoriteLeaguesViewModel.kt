package com.cheesecake.presentation.screens.favorite.favoriteLeagues

import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.ManageCompetitionUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toLeaguesUIState
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteLeaguesViewModel @Inject constructor(
    private val manageCompetitionUseCase: ManageCompetitionUseCase,
) : BaseViewModel<FavoriteLeaguesUIState, FavoriteLeaguesNavigationEvent>(
    FavoriteLeaguesUIState(), Event()
) {
    init {
        tryToExecute({ manageCompetitionUseCase.getFavoriteCompetition() }, ::onSuccess, ::onError)
    }

    private fun onSuccess(flow: Flow<List<League>>) {
        collectFlow(flow) { leagues ->
            copy(
                leagues = leagues.map { league ->
                    league.toLeaguesUIState({
                        toggleFavourite(league.leagueId)
                    }, { navigateToLeague(league.leagueId) })
                }, isLeaguesIsEmpty = leagues.isEmpty(), isLoading = false
            )
        }
    }

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(errorMessage = e.localizedMessage ?: "Unknown error.", isLoading = false)
        }
    }

    private fun navigateToLeague(leagueId: Int) {
        _event.update { Event(FavoriteLeaguesNavigationEvent.NavigateToLeague(leagueId)) }
    }

    private fun toggleFavourite(leagueId: Int) {
        viewModelScope.launch { manageCompetitionUseCase.favoriteCompetition(leagueId) }
    }
}
