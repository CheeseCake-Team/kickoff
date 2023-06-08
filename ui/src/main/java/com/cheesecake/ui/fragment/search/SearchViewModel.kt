package com.cheesecake.ui.fragment.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.TeamEntity
import com.cheesecake.domain.usecases.GetLeagueByNameUseCase
import com.cheesecake.domain.usecases.GetTeamByNameUseCase
import com.cheesecake.ui.base.BaseViewModel
import com.cheesecake.ui.mapper.toUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getLeagueByNameUseCase: GetLeagueByNameUseCase,
    private val getTeamByNameUseCase: GetTeamByNameUseCase
) : BaseViewModel() {

    val searchText = MutableLiveData("")

    private val _uiState = MutableStateFlow(SearchUIState())
    val uiState: StateFlow<SearchUIState> = _uiState

//    fun getSearchResult() {
//        viewModelScope.launch {
//            searchText.value?.let { getTeamByNameUseCase.invoke(it) }?.collect {
//
//            }
//        }
//    }

    suspend fun onSearchInputChanged(newSearchInput: String) {
        _uiState.update { it.copy(searchInput = newSearchInput) }
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            getTeamByNameUseCase(newSearchInput).collect { list ->
//                _uiState.update { searchUIState ->
//                    searchUIState.copy(
//                        searchResult = list.map { it.toUIModel() }, isLoading = false
//                    )
//                }
            }
        }

    }

    suspend fun onSearch(searchInput: String) {
        viewModelScope.launch {
            getTeamByNameUseCase(searchInput).collect { list ->
                _uiState.update { searchUIState ->
                    searchUIState.copy(
                        searchResult = list.map { it.toUIModel() }, isLoading = false
                    )
                }
            }
        }
    }

    suspend fun onSelectMealType(mealTypeUIState: SearchType) {
        TODO()
    }

    suspend fun onSelect(resultUIState: SearchResult) {
        TODO()
    }

    suspend fun onInternetDisconnected() {
        TODO()
    }

}

//private fun TeamEntity.toSearchResult(): SearchResult.Team {
//    return SearchResult.Team(
//         items =
//    )
//}






