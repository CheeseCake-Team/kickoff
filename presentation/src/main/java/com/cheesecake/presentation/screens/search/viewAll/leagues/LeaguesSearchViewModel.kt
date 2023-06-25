package com.cheesecake.presentation.screens.search.viewAll.leagues

import androidx.lifecycle.SavedStateHandle
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.GetLeagueBySearchUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import com.cheesecake.presentation.screens.search.models.LeagueSearchUIState
import com.cheesecake.presentation.screens.search.SearchEvents
import com.cheesecake.presentation.screens.search.models.toSearchUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LeaguesSearchViewModel @Inject constructor(
    private val getLeagueList: GetLeagueBySearchUseCase,
    private val args: LeaguesSearchNavigationArgs
) : BaseViewModel<AllLeaguesUIState, SearchEvents>(AllLeaguesUIState(), Event()) {

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
        return getLeagueList(args.searchQuery).toSearchUIState(::onLeagueClicked)
    }

    private fun onSearchSuccess(items: List<LeagueSearchUIState>) {
        _state.update { it.copy(items = items, isLoading = false) }
    }

    private fun onSearchError(throwable: Throwable) {
        _state.update { it.copy(error = throwable.message.toString()) }
    }

    private fun onLeagueClicked(league: League) {
        _event.update { Event(SearchEvents.LeagueClickEvent(league.leagueId,league.season.toInt())) }
    }

}