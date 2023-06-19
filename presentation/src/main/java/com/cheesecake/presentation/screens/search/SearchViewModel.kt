package com.cheesecake.presentation.screens.search

import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.usecases.GetLeagueBySearchUseCase
import com.cheesecake.domain.usecases.GetTeamByNameUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
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
    private val getTeamList: GetTeamByNameUseCase,
) : BaseViewModel<SearchUIState, SearchEvents>(SearchUIState(), Event()) {

    val searchInput = MutableStateFlow("")

    init {
        initSearchProperties()
    }

    private fun initSearchProperties() {
        viewModelScope.launch {
            searchInput.debounce(500).distinctUntilChanged().filter { it.isNotEmpty() }
                .collect(::onSearching)
        }
    }

    private suspend fun onSearching(input: String) {
        tryToExecute(
            { getSearchResult(input) }, ::onSearchSuccess, ::onSearchError
        )
    }

    private suspend fun getSearchResult(input: String) = mutableListOf<SearchResult>().apply {
        _state.update { it.copy(isLoading = true) }
        add(
            SearchResult.League(::onVewAllLClicked, getLeagueList(input).toSearchUIState(::onLeagueClicked))
        )
        add(SearchResult.Team(getTeamList(input).map { it.toSearchUIState() }))
    }

    private fun onSearchSuccess(items: List<SearchResult>) {
        _state.update { it.copy(searchResult = items, isLoading = false) }
    }

    private fun onSearchError(throwable: Throwable) {
        _state.update { it.copy(error = emptyList()) }
    }


    fun onQueryChange(input: String) {
        viewModelScope.launch {
            _state.update { it.copy(searchInput = input) }
            searchInput.emit(input)
        }
    }

    private fun onLeagueClicked(id: Int, season: Int) {
        _event.update { Event(SearchEvents.LeagueClickEvent(id, season)) }
    }

    private fun onVewAllLClicked() {
        _event.update { Event(SearchEvents.ViewAllLClickEvent(searchInput.value)) }
    }

    private fun onTeamClicked() {
        _event.update { Event(SearchEvents.TeamClickEvent) }
    }


    suspend fun onInternetDisconnected() {
        TODO()
    }

}







