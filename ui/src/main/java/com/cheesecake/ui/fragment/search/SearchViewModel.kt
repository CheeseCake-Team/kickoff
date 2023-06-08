package com.cheesecake.ui.fragment.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.usecases.GetLeagueByNameUseCase
import com.cheesecake.domain.usecases.GetTeamByNameUseCase
import com.cheesecake.ui.base.BaseViewModel
import com.cheesecake.ui.mapper.toUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
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
    private val getTeamByNameUseCase: GetTeamByNameUseCase,
) : BaseViewModel<SearchUIState>() {

    override val uiState: SearchUIState = SearchUIState()

    val searchInput = MutableLiveData<String>()

    private val searchInputFlow = MutableSharedFlow<String>()

    init {
        viewModelScope.launch {
            searchInputFlow
                .filter { it.isNotEmpty() }
                .debounce(3000)
                .distinctUntilChanged()
                .collectLatest { debouncedInput ->
                    try {
                        delay(500)
                        Log.i("onSearchInputChanged: ", "debounced before")
                        getTeamByNameUseCase(debouncedInput).collect {
                            _state.update { searchUIState ->
                                searchUIState.copy(
                                    searchResult = it.map { it.toUIModel() },
                                    isLoading = false
                                )
                            }
                            Log.i("onSearchInputChanged: ", "debounced after")
                        }
                    } catch (e: Exception) {
                        _state.update { it.copy(error = emptyList()) }
                    }
                }
        }
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







