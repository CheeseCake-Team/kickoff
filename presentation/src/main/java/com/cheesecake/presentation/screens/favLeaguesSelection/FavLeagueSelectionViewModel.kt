package com.cheesecake.presentation.screens.favLeaguesSelection

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.AddFavouriteLeagueListUseCase
import com.cheesecake.domain.usecases.GetLeagueBySearchUseCase
import com.cheesecake.domain.usecases.GetLeagueListUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toFavLeagueItemUIState
import com.cheesecake.presentation.mapper.toLeague
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavLeagueSelectionViewModel @Inject constructor(
    private val GetLeagueListUseCase: GetLeagueListUseCase,
    private val AddFavouriteLeagueListUseCase: AddFavouriteLeagueListUseCase,
    private val getLeagueListBySearch: GetLeagueBySearchUseCase
) : BaseViewModel<FavLeagueSelectionUIState, FavLeagueSelectionNavigationEvent>(
    FavLeagueSelectionUIState(),
    Event()
) {

    private val searchInput = MutableStateFlow(_state.value.searchInput)
    private val _favLeagueSelectionUIState = MutableStateFlow(FavLeagueSelectionUIState())
    val favLeagueSelectionUIState = _favLeagueSelectionUIState.asStateFlow()

    init {
        getAllLeagues()
        onClickSearch()
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
            } ?: run {
                val league = favLeagueSelectionUIState.leaguesItems.find { it.leagueId == leagueId }
                favLeagueSelectionUIState.selectedLeagues.add(
                    league?.toLeague()!!.copy(isFavourite = true)
                )
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

    private fun onClickSearch() {
        viewModelScope.launch {
            searchInput.debounce(1000).distinctUntilChanged().filter { it.isNotEmpty() }
                .collect(::tryToSearch)
        }
    }

    private suspend fun tryToSearch(input: String) {
        tryToExecute(
            { getSearchResult(input) }, ::onSearchSuccess, ::onSearchError
        )
    }

    private suspend fun getSearchResult(input: String) : List<League> {
        _favLeagueSelectionUIState.update { it.copy(isLoading = true) }
        return getLeagueListBySearch(input)
    }

    private fun onSearchSuccess(items: List<League>) {
        val searchItems = items.map { league ->
            league.toFavLeagueItemUIState { onFavouriteLeagueSelect(league.leagueId) }
        }
        _favLeagueSelectionUIState.update {
            it.copy(
                leaguesItems = searchItems,
                isLoading = false
            )
        }
    }

    private fun onSearchError(throwable: Throwable) {
        _favLeagueSelectionUIState.update {
            it.copy(
                errorMessage = throwable.message.toString(),
                isLoading = false
            )
        }
        Log.i("onSearchError: ", _favLeagueSelectionUIState.value.errorMessage)
    }

    fun onQueryChange(input: String) {
        viewModelScope.launch {
            _favLeagueSelectionUIState.update { it.copy(searchInput = input) }
            searchInput.emit(input)
        }
    }

}