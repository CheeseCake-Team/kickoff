package com.cheesecake.presentation.screens.homeSearch

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.usecases.RecentSearchUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
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
        tryToExecute(
            { getData() }, ::onGetDataSuccess, ::onGetDataError
        )
    }

    private suspend fun getData(): SuccessData {
        _state.update { it.copy(isLoading = true) }
        return SuccessData(
            recentUseCase.getRecentSearch(),
        )
    }

    private fun onGetDataSuccess(data: SuccessData) {
        val dataList = mutableListOf<HomeSearchData>()
//        collectFlow(data.flow) { list ->
//            dataList.clear()
//            dataList.add(
//                HomeSearchData.RecentSearches((::onClickDeleteAll),
//                    list.map { it.toUIState { onClickDeleteRecentById(it.id) } })
//            )
//            this.copy(data = dataList, isLoading = false)
//        }
        viewModelScope.launch {
            data.flow.collect { list ->
                dataList.clear()
                dataList.add(
                    HomeSearchData.RecentSearches(
                        (::onClickDeleteAll),
                        list.map { it.toUIState { onClickDeleteRecentById(it.id) } }
                    )
                )
                _state.update { it.copy(data = dataList, isLoading = false) }
            }
        }
    }


    private fun onGetDataError(throwable: Throwable) {
        _state.update { it.copy(error = throwable.message.toString()) }
        Log.i("onSearchError: ", _state.value.error)
    }

    private suspend fun getRecentSearchesData(): List<RecentSearchUIState> {
        var data = listOf<RecentSearchUIState>()
        viewModelScope.launch {
            recentUseCase.getRecentSearch().collect { list ->
                data = list.map {
                    it.toUIState { onClickDeleteRecentById(it.id) }
                }
            }
        }

        Log.i("getRecentSearchesData: ", data.toString())
        return data
    }

//    fun tryto() {
//        viewModelScope.launch {
//            recentUseCase.getRecentSearch().collect { list ->
//                val recentItems = (list.map { it.toUIState { onClickDeleteRecentById(it.id) } })
//                val data = mutableListOf<HomeSearchData>(
//                    HomeSearchData.RecentSearches(
//                        ::onClickDeleteAll, recentItems
//                    )
//                )
//                _state.update { it.copy(data = data) }
//            }
//        }
//
//    }

    fun onClickSearchBar() {
        _event.update { Event(HomeSearchEvent.SearchBarClick) }
    }

//    private fun onClickRecentItem(recent: RecentSearchUIState) {
////        _event.update { Event(HomeSearchEvent.RecentClickSearchEvent(recent)) }
//
//    }

    private fun onClickDeleteRecentById(id: Int) {
        viewModelScope.launch {
            recentUseCase.deleteRecentSearchById(id)
        }
    }

    private fun onClickDeleteAll() {
        viewModelScope.launch {
            recentUseCase.deleteRecentSearches()
        }
    }


}




