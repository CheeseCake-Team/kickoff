package com.cheesecake.presentation.screens.favLeaguesSelection

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.AddFavouriteLeagueListUseCase
import com.cheesecake.domain.usecases.GetLeagueBySearchUseCase
import com.cheesecake.domain.usecases.GetLeagueListUseCase
import com.cheesecake.domain.usecases.OnboardingUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toFavLeagueItemUIState
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class FavLeagueSelectionViewModel @Inject constructor(
    private val getLeagueListUseCase: GetLeagueListUseCase,
    private val addFavouriteLeagueListUseCase: AddFavouriteLeagueListUseCase,
    private val getLeagueListBySearch: GetLeagueBySearchUseCase
) : BaseViewModel<FavLeagueSelectionUIState, FavLeagueSelectionNavigationEvent>(
    FavLeagueSelectionUIState(),
    Event()
) {

    init {
        collectFlow(state.value.searchInput.debounce(1000).distinctUntilChanged()) {
            if (it.isBlank() || it.isEmpty()) {
                tryToExecute({ getLeagueListUseCase() }, ::onLeaguesSuccess, ::onLeagueError)
            } else {
                tryToExecute({ getLeagueListBySearch(it) }, ::onSearchSuccess, ::onSearchError)
            }
            state.value
        }
    }





    private fun onLeaguesSuccess(leagues: List<League>) {
        _state.update {
            it.copy(
                leaguesItems = leagues.map { league ->
                    league.toFavLeagueItemUIState { onFavouriteLeagueSelect(league) }
                },
                isLoading = false,
                onNextClick = { addToFavourite() },
                onSkipClick = { addToFavourite() }
            )
        }
    }

    private fun onLeagueError(e: Throwable) {
        _state.update {
            it.copy(errorMessage = e.message.toString(), isLoading = false)
        }
    }

    private fun onFavouriteLeagueSelect(league: League) {
        addFavouriteLeagueListUseCase.addLeague(league)
        _state.update { favLeagueSelectionUIState ->
             favLeagueSelectionUIState.copy (
                leaguesItems = favLeagueSelectionUIState.leaguesItems.map {
                    if (it.leagueId == league.leagueId) it.copy (isSelected = !it.isSelected) else it
                }
            )
        }
    }

    private fun addToFavourite() {
        tryToExecute({ addFavouriteLeagueListUseCase.execute() }, ::onAddSuccess, ::onError)
    }

    private fun onAddSuccess(boolean: Boolean) {
        _event.update { Event(FavLeagueSelectionNavigationEvent.NavigateToFavTeamsSelection) }
    }

    private fun onError(e: Throwable) {
        _state.update { it.copy(errorMessage = e.localizedMessage ?: "Unknown error.", isLoading = false) }
    }

    private fun onSearchSuccess(items: List<League>) {
        _state.update {
            it.copy(
                leaguesItems = items.map { league ->
                    league.toFavLeagueItemUIState { onFavouriteLeagueSelect(league) }
                },
                isLoading = false
            )
        }
    }

    private fun onSearchError(throwable: Throwable) {
        _state.update { it.copy(errorMessage = throwable.message.toString(), isLoading = false) }
    }

}