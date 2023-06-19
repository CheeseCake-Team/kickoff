package com.cheesecake.presentation.screens.search.viewAll.leagues

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.cheesecake.domain.usecases.GetLeagueBySearchUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import com.cheesecake.presentation.screens.search.LeagueSearchUIState
import com.cheesecake.presentation.screens.search.SearchEvents
import com.cheesecake.presentation.screens.search.toSearchUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LeaguesSearchViewModel @Inject constructor(
    private val getLeagueList: GetLeagueBySearchUseCase,
    state: SavedStateHandle
) : BaseViewModel<AllLeaguesUIState, SearchEvents>(AllLeaguesUIState(), Event()) {


    private val ars = state.let {
        LeaguesSearchFragmentArgs.fromSavedStateHandle(it)
    }

    init {
        initLeagueList()
    }

    private fun initLeagueList() {
        tryToExecute(
            { getSearchResult() }, ::onSearchSuccess, (::onSearchError)
        )
    }

    private suspend fun getSearchResult(): List<LeagueSearchUIState> {
        _state.update { it.copy(isLoading = true) }
        return getLeagueList(ars.searchInput).toSearchUIState(::onLeagueClicked)
    }

    private fun onSearchSuccess(items: List<LeagueSearchUIState>) {
        _state.update { it.copy(items = items, isLoading = false) }
        Log.i("onSearchSuccessssssssssssss: ", _state.value.items.toString())
    }

    private fun onSearchError(throwable: Throwable) {
        Log.i("onSearchInputError: ", throwable.message.toString())
        _state.update { it.copy(error = emptyList()) }
    }

    private fun onLeagueClicked(id:Int, season:Int) {
        _event.update { Event(SearchEvents.LeagueClickEvent(id,season)) }
    }

}