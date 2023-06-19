package com.cheesecake.presentation.screens.search

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.usecases.GetLeagueBySearchUseCase
import com.cheesecake.domain.usecases.GetTeamByNameUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
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

    private val searchItems = mutableListOf<SearchResult>()

    val searchInput = MutableStateFlow("")

    init {
        initSearchProperties()
    }

    private fun initSearchProperties() {
        viewModelScope.launch {
            searchInput.debounce(500).distinctUntilChanged().filter { it.isNotEmpty() }
                .collectLatest(::onSearching)
        }
    }

    private suspend fun onSearching(input: String) {
        tryToExecute(
            { getSearchResult(input) },
            ::onSearchSuccess,
            ::onSearchError
        )
    }

    private suspend fun getSearchResult(input: String): List<SearchResult> {
        _state.update { it.copy(isLoading = true) }
        searchItems.clear()
        searchItems.add(SearchResult.League((::onVewAllLClicked),getLeagueList(input).map {
            it.toSearchUIState(::onLeagueClicked,)
        }))
        searchItems.add(SearchResult.Team(getTeamList(input).map { it.toSearchUIState() }))
        Log.i("getSearchResult:notcleared ", searchItems.toString())
        return searchItems
    }

    private fun onSearchSuccess(items: List<SearchResult>) {
        Log.i("onSearchInputChanged: ", "debounced before")
        Log.i("onSearchInputChanged: ", _state.value.isLoading.toString())
        _state.update { it.copy(searchResult = items, isLoading = false) }
    }

    private fun onSearchError(throwable: Throwable) {
        Log.i("onSearchInputError: ", throwable.message.toString())
        _state.update { it.copy(error = emptyList()) }
    }

    private suspend fun onSearchInputChanged(newSearchInput: String) {
        _state.update { it.copy(searchInput = newSearchInput) }
        searchInput.emit(newSearchInput)
    }

    fun onSearch(input: String) {
        viewModelScope.launch {
            onSearchInputChanged(input)
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


    suspend fun onSelectSearchType(searchTypeUIState: SearchType) {
        TODO()
    }

    suspend fun onSelect(resultUIState: SearchResult) {
        TODO()
    }

    suspend fun onInternetDisconnected() {
        TODO()
    }

}







