package com.cheesecake.presentation.screens.favLeaguesSelection

import android.util.Log
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.AddFavouriteLeagueListUseCase
import com.cheesecake.domain.usecases.GetLeagueListUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toFavLeagueItemUIState
import com.cheesecake.presentation.mapper.toLeague
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class FavLeagueSelectionViewModel @Inject constructor(
    private val GetLeagueListUseCase: GetLeagueListUseCase,
    private val AddFavouriteLeagueListUseCase: AddFavouriteLeagueListUseCase
) : BaseViewModel<FavLeagueSelectionUIState, FavLeagueSelectionNavigationEvent>(
    FavLeagueSelectionUIState(),
    Event()
) {

    private val _favLeagueSelectionUIState = MutableStateFlow(FavLeagueSelectionUIState())
    val favLeagueSelectionUIState = _favLeagueSelectionUIState.asStateFlow()

    init {
        getAllLeagues()
    }

    private fun getAllLeagues() {
        tryToExecute({ GetLeagueListUseCase() }, ::onLeaguesSuccess, ::onLeagueError)
    }

    private fun onLeagueError(e: Throwable) {
        _favLeagueSelectionUIState.update {
            it.copy(errorMessage = e.message.toString(), isLoading = false)
        }
    }

    private fun onLeaguesSuccess(leagues: List<League>) {
        _favLeagueSelectionUIState.update {
            it.copy(
                leaguesItems = leagues.map { league ->
                    league.toFavLeagueItemUIState { onFavouriteLeagueSelect(league.leagueId) }
                },
                isLoading = false
            )
        }
    }

    private fun onFavouriteLeagueSelect(leagueId: Int) {
        _favLeagueSelectionUIState.update { favLeagueSelectionUIState ->
            favLeagueSelectionUIState.selectedLeagues.find { it.leagueId == leagueId }?.let {
                val index = favLeagueSelectionUIState.selectedLeagues.indexOf(it)
                favLeagueSelectionUIState.selectedLeagues.removeAt(index)
                it.copy(isFavourite = false)
            }?: run {
                val league = favLeagueSelectionUIState.leaguesItems.find { it.leagueId == leagueId }
                favLeagueSelectionUIState.selectedLeagues.add(league?.toLeague()!!.copy(isFavourite = true))
            }
            favLeagueSelectionUIState.copy(
                selectedLeagues = favLeagueSelectionUIState.selectedLeagues,
            )
        }
    }

    fun addToFavourite() {
        tryToExecute(
            {
                _favLeagueSelectionUIState.collect {
                    AddFavouriteLeagueListUseCase(it.selectedLeagues)
                }

            }, ::onAddSuccess, ::onError
        )
    }

    private fun onAddSuccess(boolean: Boolean) {
        _event.update { Event(FavLeagueSelectionNavigationEvent.NavigateToFavTeamsSelection) }
    }

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(errorMessage = e.localizedMessage ?: "Unknown error.", isLoading = false)
        }
    }
}