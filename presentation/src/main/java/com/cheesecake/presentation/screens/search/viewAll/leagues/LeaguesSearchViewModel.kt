package com.cheesecake.presentation.screens.search.viewAll.leagues

import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.ManageCompetitionsUseCase
import com.cheesecake.domain.usecases.SaveRecentSearchUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import com.cheesecake.presentation.screens.search.SearchEvents
import com.cheesecake.presentation.screens.search.models.LeagueSearchUIState
import com.cheesecake.presentation.screens.search.models.toRecentSearch
import com.cheesecake.presentation.screens.search.models.toSearchUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeaguesSearchViewModel @Inject constructor(
    private val manageCompetitionsUseCase: ManageCompetitionsUseCase,
    private val saveRecentSearch: SaveRecentSearchUseCase,
    private val args: LeaguesSearchNavigationArgs
) : BaseViewModel<LeaguesUIState, SearchEvents>(LeaguesUIState(), Event()) {

    init {
        initLeagueList()
    }

    private fun initLeagueList() {
        tryToExecute(
            { getSearchResult() }, ::onSearchSuccess, (::onSearchError)
        )
    }

    private suspend fun getSearchResult(): List<LeagueSearchUIState> {
        _state.update { it.copy(isResultEmpty = false, isLoading = true) }
        return manageCompetitionsUseCase.searchForCompetitions(args.searchQuery)
            .toSearchUIState(::onLeagueClicked)
    }

    private fun onSearchSuccess(items: List<LeagueSearchUIState>) {
        _state.update { it.copy(items = items, isLoading = false, isResultEmpty = items.isEmpty()) }
    }

    private fun onSearchError(throwable: Throwable) {
        _state.update { it.copy(error = throwable.message.toString()) }
    }

    private fun onLeagueClicked(league: League) {
        viewModelScope.launch {
            saveRecentSearch(league.toRecentSearch())
            _event.update { Event(SearchEvents.LeagueClickEvent(league.leagueId)) }
        }
    }
}