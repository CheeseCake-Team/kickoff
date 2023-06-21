package com.cheesecake.presentation.screens.homeSearch

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.RecentSearch
import com.cheesecake.domain.usecases.GetRecentSearchUseCase
import com.cheesecake.domain.usecases.SaveRecentSearchUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeSearchViewModel @Inject constructor(
    private val getRecentSearch: GetRecentSearchUseCase,
    private val saveRecentSearch: SaveRecentSearchUseCase,
) : BaseViewModel<HomeSearchUIState, HomeSearchEvent>(HomeSearchUIState(), Event()) {


    init {
        tryToGetData()
    }

    private fun tryToGetData() {
        tryToExecute(
            { getData() }, ::onGetDataSuccess, ::onGetDataError
        )
    }

    private suspend fun getData(): List<HomeSearchData> {
        _state.update { it.copy(isLoading = true) }
        return mutableListOf<HomeSearchData>().apply {
            add(HomeSearchData.RecentSearches(::onClickDeleteAll, getRecentSearch().map {
                it.toUIState(::onClickRecentSearch)
            }))
        }
    }

    private fun onGetDataSuccess(newData: List<HomeSearchData>) {
        _state.update { it.copy(data = newData) }
    }

    private fun onGetDataError(throwable: Throwable) {
        _state.update { it.copy(error = throwable.message.toString()) }
        Log.i("onSearchError: ", _state.value.error)
    }

    private fun onClickRecentSearch(recent: RecentSearchUIState) {
//        _event.update { Event(HomeSearchEvent.RecentClickSearchEvent(recent)) }
        viewModelScope.launch {
            saveRecentSearch(recent.toEntity())
        }
    }

    private fun onClickDeleteAll() {

    }


}




