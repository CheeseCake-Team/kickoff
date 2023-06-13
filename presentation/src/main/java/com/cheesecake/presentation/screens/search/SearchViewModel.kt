package com.cheesecake.presentation.screens.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.usecases.GetLeagueByNameUseCase
import com.cheesecake.domain.usecases.GetTeamByNameUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toUIModel
import com.cheesecake.presentation.models.TeamUIState
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
    private val getLeagueByNameUseCase: GetLeagueByNameUseCase,
    private val getTeamList: GetTeamByNameUseCase,
) : BaseViewModel<SearchUIState>(SearchUIState()) {


    val searchInput = MutableLiveData("")

    private val searchInputFlow = MutableSharedFlow<String>()

    val isResultEmptyOnly =
        MutableStateFlow((!(state.value.isLoading)) && (state.value.searchResult.isEmpty()))

    init {
        initSearchProperties()
    }

    private fun initSearchProperties() {
        viewModelScope.launch {
            searchInputFlow.debounce(500).distinctUntilChanged().filter { it.isNotEmpty() }
                .collectLatest(::onSearching)
        }
    }

    private suspend fun onSearching(debouncedInput: String) {
        tryToExecute(
            { getTeamList(debouncedInput).map { it.toUIModel() } },
            ::onSearchSuccess,
            ::onSearchError
        )
    }

    private fun onSearchSuccess(teamUIList: List<TeamUIState>) {
        Log.i("onSearchInputChanged: ", "debounced before")
        Log.i("onSearchInputChanged: ", teamUIList.toString())
        _state.update { it.copy(searchResult = teamUIList, isLoading = false) }
    }

    private fun onSearchError(throwable: Throwable) {
        Log.i("onSearchInputError: ", throwable.message.toString())
        _state.update { it.copy(error = emptyList()) }
    }

    suspend fun onSearchInputChanged(newSearchInput: String) {
        _state.update { it.copy(isLoading = true) }
        _state.update { it.copy(searchInput = newSearchInput) }
        searchInputFlow.emit(newSearchInput)
    }


    suspend fun onSearch(searchInput: String) {
        TODO()
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







