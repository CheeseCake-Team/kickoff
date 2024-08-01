package com.cheesecake.presentation.screens.search

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.usecases.ManageCompetitionsUseCase
import com.cheesecake.domain.usecases.ManageRecentSearchUseCase
import com.cheesecake.domain.usecases.ManageTeamsUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import com.cheesecake.presentation.screens.search.models.SearchResult
import com.cheesecake.presentation.screens.search.models.SearchType
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
    private val manageCompetitionsUseCase: ManageCompetitionsUseCase,
    private val manageTeamsUseCase: ManageTeamsUseCase,
    private val manageRecentSearchUseCase: ManageRecentSearchUseCase
) : BaseViewModel<SearchUIState, SearchEvents>(SearchUIState(), Event()) {
    private val searchInput = MutableStateFlow(_state.value.searchQuery)

    init {
        getData()
    }

    private suspend fun tryToSearch(input: String) {
        tryToExecute(
            { getSearchResult(input) }, ::onSearchSuccess
        )
    }

    private suspend fun getSearchResult(input: String): List<SearchResult> {
        _state.update { it.copy(isResultEmpty = false, isLoading = true) }
        return mutableListOf<SearchResult>().apply {
            val leaguesItems = manageCompetitionsUseCase.searchForCompetitions(input)
                .toSearchUIState(::onClickLeague)

            val teamsItems = manageTeamsUseCase.searchForTeams(input).toSearchUIState(::onClickTeam)
            add(
                SearchResult.League(::onClickViewAll, leaguesItems.take(6), leaguesItems.size)
            )
            add(SearchResult.Team(::onClickViewAll, teamsItems.take(6), teamsItems.size))
        }
    }

    private fun onSearchSuccess(items: List<SearchResult>) {
        _state.update {
            it.copy(
                searchResult = items,
                isResultEmpty = getIfResultEmpty(items),
                isLoading = false,
            )
        }
    }

    private fun getIfResultEmpty(items: List<SearchResult>): Boolean {
        Log.i("getIfResultEmpty: ", (items.all { it.list.isEmpty() }.toString()))
        return (items.all { it.list.isEmpty() })
    }

    fun onQueryChange(input: String) {
        viewModelScope.launch {
            _state.update { it.copy(searchQuery = input) }
            searchInput.emit(input)
        }
    }

    private fun onClickViewAll(type: SearchType) {
        _event.update { Event(SearchEvents.ViewAllLClickEvent(_state.value.searchQuery, type)) }
    }

    private fun onClickLeague(league: League) {
        viewModelScope.launch {
            _event.update {
                Event(
                    SearchEvents.LeagueClickEvent(
                        league.leagueId
                    )
                )
            }
            manageRecentSearchUseCase.addOrUpdateRecentSearch(league.toRecentSearch())
        }
    }

    private fun onClickTeam(team: Team) {
        viewModelScope.launch {
            manageRecentSearchUseCase.addOrUpdateRecentSearch(team.toRecentSearch())
            _event.update { Event(SearchEvents.TeamClickEvent(team.id)) }
        }
    }

    fun onClickBack() {
        _event.update { Event(SearchEvents.BackClickEvent) }
    }

    suspend fun onInternetDisconnected() {
        TODO()
    }

    override fun getData() {
        viewModelScope.launch {
            searchInput.debounce(1000).distinctUntilChanged().filter { it.isNotEmpty() }
                .collect(::tryToSearch)
        }
    }
}