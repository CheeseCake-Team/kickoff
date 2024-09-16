package com.cheesecake.presentation.screens.homeSearch

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.RecentSearch
import com.cheesecake.domain.usecases.ManageRecentSearchUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeSearchViewModel @Inject constructor(
    private val manageRecentSearchUseCase: ManageRecentSearchUseCase,
) : BaseViewModel<HomeSearchUiState, HomeSearchEvent>(HomeSearchUiState(), Event()) {
    init {
        getData()
    }

    override fun getData() {
        _state.update { it.copy(isLoading = true) }
        tryToExecuteSuspend( {
            SuccessData(
                manageRecentSearchUseCase.getRecentSearches(),
            )
        }, ::onGetDataSuccess)
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

    fun onClickSearchBar() {
        _event.update { Event(HomeSearchEvent.SearchBarClick) }
    }

    private fun onClickRecent(recent: RecentSearch) {
        _event.update { Event(HomeSearchEvent.RecentClickEvent(recent)) }
        Log.e("onClickRecent: ", recent.toString())
    }

    private fun onClickDeleteAll() {
        viewModelScope.launch {
            manageRecentSearchUseCase.deleteRecentSearches()
        }
    }
}




