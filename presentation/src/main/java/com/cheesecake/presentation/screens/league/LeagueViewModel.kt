package com.cheesecake.presentation.screens.league

import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.FavouriteLeagueUseCase
import com.cheesecake.domain.usecases.GetLeagueByIdAndSeasonUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toUIState
import com.cheesecake.presentation.models.Event
import com.cheesecake.presentation.screens.favoriteTeams.FavoriteTeamsNavigationEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeagueViewModel @Inject constructor(
    private val getLeagueByIdAndSeasonUseCase: GetLeagueByIdAndSeasonUseCase,
    private val favouriteLeagueUseCase: FavouriteLeagueUseCase
) : BaseViewModel<LeagueUIState, Event<LeagueNavigationEvent?>>
    (
    LeagueUIState(),
    Event<LeagueNavigationEvent?>(null)
) {

    init {
        getLeague(39, 2022)
    }

    fun toggleFavourite(leagueId: Int, leagueSeason: Int) {
        viewModelScope.launch {
            favouriteLeagueUseCase(leagueId, leagueSeason).let {
                _state.update { uiState -> uiState.copy(isFavourite = it.isFavourite) }
            }
        }
    }

    private fun getLeague(leagueId: Int, leagueSeason: Int) {
        tryToExecute({ getLeagueByIdAndSeasonUseCase(leagueId, leagueSeason) }, ::onSuccess, ::onError)
    }

    private fun onSuccess(league: League?) {
        league?.let {
            _state.update { uiState ->
                uiState.copy{
                    league.toUIState({ toggleFavourite(it.leagueId, it.leagueSeason.toInt())}, ::onBackClick)
                }
            }
        }
    }

    private fun onBackClick() {
        _event.update { Event(LeagueNavigationEvent.NavigateBack) }
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
