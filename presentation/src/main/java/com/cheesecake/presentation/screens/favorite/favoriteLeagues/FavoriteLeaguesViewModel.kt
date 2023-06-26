package com.cheesecake.presentation.screens.favorite.favoriteLeagues

import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.FavouriteLeagueUseCase
import com.cheesecake.domain.usecases.GetFavoriteLeaguesUseCase
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
    private val getFavoriteLeaguesUseCase: GetFavoriteLeaguesUseCase,
    private val favoriteLeagueUseCase: FavouriteLeagueUseCase,
    ) : BaseViewModel<FavoriteLeaguesUIState, FavoriteLeaguesNavigationEvent>(
    FavoriteLeaguesUIState(), Event()
) {

    init {
        tryToExecute({ getFavoriteLeaguesUseCase() }, ::onSuccess, ::onError)
    }

    private fun onSuccess(flow: Flow<List<League>>) {
        collectFlow(flow) { leagues ->
            copy(
                leagues = leagues.map { league ->
                    league.toLeaguesUIState({
                        toggleFavourite(
                            league.leagueId, league.season
                        )
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

    private fun toggleFavourite(leagueId: Int, leagueSeason: Int) {
        viewModelScope.launch { favoriteLeagueUseCase(leagueId, leagueSeason) }
    }

}
