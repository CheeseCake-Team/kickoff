package com.cheesecake.presentation.screens.homeSearch

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.RecentSearch
import com.cheesecake.domain.usecases.RecentSearchUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeSearchViewModel @Inject constructor(
    private val recentUseCase: RecentSearchUseCase,
) : BaseViewModel<HomeSearchUIState, HomeSearchEvent>(HomeSearchUIState(), Event()) {

    init {
        tryToGetData()
    }

    private fun tryToGetData() {
        tryToExecuteSuspend(::getData, ::onGetDataSuccess, ::onGetDataError)
    }


    private fun getData(): SuccessData {
        _state.update { it.copy(isLoading = true) }
        return SuccessData(
            recentUseCase.getRecentSearch(),
        )
    }

    private suspend fun onGetDataSuccess(data: SuccessData) {
        data.flow.collect { list ->
            _state.update { it ->
                it.copy(
                    data = listOf(
                        HomeSearchData.RecentSearches(
                            ::onClickDeleteAll,
                            list.map { it.toUIState {onClickRecent(it)} })
                    ), isLoading = false
                )
            }
        }
    }

    private fun onGetDataError(throwable: Throwable) {
        _state.update { it.copy(error = throwable.message.toString()) }
        Log.i("onSearchError: ", _state.value.error)
    }

    fun onClickSearchBar() {
        _event.update { Event(HomeSearchEvent.SearchBarClick) }
    }

    private fun onClickRecent(recent: RecentSearch) {
        _event.update { Event(HomeSearchEvent.RecentClickEvent(recent)) }
    }

    private fun onClickDeleteAll() {
        viewModelScope.launch {
            recentUseCase.deleteRecentSearches()
        }
    }


}




