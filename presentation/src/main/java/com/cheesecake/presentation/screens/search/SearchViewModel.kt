package com.cheesecake.presentation.screens.search

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.GetLeagueBySearchUseCase
import com.cheesecake.domain.usecases.GetTeamBySearchUseCase
import com.cheesecake.domain.usecases.SaveRecentSearchUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toTeamUIState
import com.cheesecake.presentation.models.Event
import com.cheesecake.presentation.screens.search.models.LeagueSearchUIState
import com.cheesecake.presentation.screens.search.models.SearchResult
import com.cheesecake.presentation.screens.search.models.SearchUIState
import com.cheesecake.presentation.screens.search.models.toRecentSearch
import com.cheesecake.presentation.screens.search.models.toSearchUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getLeagueList: GetLeagueBySearchUseCase,
    private val getTeamList: GetTeamBySearchUseCase,
    private val saveRecentSearch: SaveRecentSearchUseCase
) : BaseViewModel<SearchUIState, SearchEvents>(SearchUIState(), Event()) {

    private val searchInput = MutableStateFlow(_state.value.searchInput)

    init {
        initSearchProperties()
    }

    private fun initSearchProperties() {
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

    private suspend fun getSearchResult(input: String): List<SearchResult> {
        _state.update { it.copy(isLoading = true) }
        return mutableListOf<SearchResult>().apply {
            val leaguesItems = getLeagueList(input).toSearchUIState(::onClickLeague)

            val teamsItems = getTeamList(input).map { it.toTeamUIState {} }
            add(
                SearchResult.League(::onClickViewAll, leaguesItems.take(6), leaguesItems.size)
            )
            add(SearchResult.Team(teamsItems.take(6), teamsItems.size))
        }
    }

    private fun onSearchSuccess(items: List<SearchResult>) {
        _state.update {
            it.copy(
                searchResult = items,
                isLoading = false,
                isResultEmpty = getIfResultEmpty(items)
            )
        }
    }

    private fun onSearchError(throwable: Throwable) {
        _state.update { it.copy(error = throwable.message.toString(), isLoading = false) }
        Log.i("onSearchError: ", _state.value.error)
    }

    private fun getIfResultEmpty(items: List<SearchResult>): Boolean {
        return items.all {
            it.list.isEmpty()
        }
    }

    fun onQueryChange(input: String) {
        viewModelScope.launch {
            _state.update { it.copy(searchInput = input) }
            searchInput.emit(input)
        }
    }

    private fun onClickLeague(league: League) {
        viewModelScope.launch {
            saveRecentSearch(league.toRecentSearch())
        }
        _event.update { Event(SearchEvents.LeagueClickEvent(league.leagueId, league.season.toInt())) }
    }

    private fun onClickViewAll() {
        _event.update { Event(SearchEvents.ViewAllLClickEvent(_state.value.searchInput)) }
    }

    private fun onClickTeam(id: Int, season: Int) {
        _event.update { Event(SearchEvents.TeamClickEvent(id, season)) }
    }

    fun onClickBack() {
        _event.update { Event(SearchEvents.BackClickEvent) }
    }

    suspend fun onInternetDisconnected() {
        TODO()
    }

}







