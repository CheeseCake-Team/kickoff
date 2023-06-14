package com.cheesecake.presentation.ui.search

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.usecases.GetLeagueBySearchUseCase
import com.cheesecake.domain.usecases.GetTeamByNameUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
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
) : BaseViewModel<SearchUIState>(SearchUIState()) {


    val searchInput = MutableStateFlow("")


    val searchType = MutableStateFlow(SearchType.TEAM)

//    val isResultEmptyOnly =
//        MutableStateFlow((!(state.value.isLoading)) && (state.value.searchResult.isEmpty()))

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

    private suspend fun getSearchResult(input: String): SearchResult {
        _state.update { it.copy(isLoading = true) }
        return when(searchType.value) {
            SearchType.TEAM -> {
                SearchResult.Team(getTeamList(input).map { it.toUIModel() })
            }
            else -> { TODO() }
            //SearchType.LEAGUE -> getLeagueList(input)
        }
    }

    private fun onSearchSuccess(items: SearchResult) {
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







