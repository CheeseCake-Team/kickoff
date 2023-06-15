package com.cheesecake.presentation.screens.favoriteLeagues

import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.FavouriteLeagueUseCase
import com.cheesecake.domain.usecases.GetFavoriteLeaguesUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toUIState
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteLeaguesViewModel @Inject constructor(
    private val getFavoriteLeaguesUseCase: GetFavoriteLeaguesUseCase,
    private val favoriteLeagueUseCase: FavouriteLeagueUseCase
) : BaseViewModel<FavoriteLeaguesUIState>(FavoriteLeaguesUIState()) {

    private val _favoriteLeaguesEvent = MutableStateFlow<Event<NavigateEvent>?>(null)
    val favoriteLeaguesEvent = _favoriteLeaguesEvent.asStateFlow()

    init {
        getFavoriteLeagues()
    }

    private fun getFavoriteLeagues() {
        tryToExecute({ getFavoriteLeaguesUseCase() }, ::onSuccess, ::onError)
    }

    private fun onSuccess(flow: Flow<List<League>>) {
        viewModelScope.launch {
            flow.collect { leagues ->
                _state.update { favoriteLeaguesUIState ->
                    favoriteLeaguesUIState.copy(
                        leagues = leagues.map { league ->
                            league.toUIState(
                                { toggleFavourite(league.leagueId, league.leagueSeason.toInt()) },
                                { navigateToLeague(league.leagueId) }
                            )
                        },
                        isLeaguesIsEmpty = leagues.isEmpty(),
                        isLoading = false
                    )
                }
            }
        }
    }

    private fun navigateToLeague(leagueId: Int) {
        _favoriteLeaguesEvent.update { Event(NavigateEvent.NavigateToLeague(leagueId)) }
    }

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(
                errorMessage = e.localizedMessage ?: "Unknown error.",
                isLoading = false
            )
        }
    }

    private fun toggleFavourite(leagueId: Int, leagueSeason: Int) {
        viewModelScope.launch {
            favoriteLeagueUseCase(leagueId, leagueSeason).toString()
        }
    }

}

sealed interface NavigateEvent {
    data class NavigateToLeague(val leagueId: Int) : NavigateEvent
}