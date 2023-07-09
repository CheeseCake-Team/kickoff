package com.cheesecake.presentation.screens.search.viewAll.teams

import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.usecases.GetTeamBySearchUseCase
import com.cheesecake.domain.usecases.SaveRecentSearchUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import com.cheesecake.presentation.screens.search.SearchEvents
import com.cheesecake.presentation.screens.search.models.TeamSearchUIState
import com.cheesecake.presentation.screens.search.models.toRecentSearch
import com.cheesecake.presentation.screens.search.models.toSearchUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamsSearchViewModel @Inject constructor(
    private val getTeamsList: GetTeamBySearchUseCase,
    private val saveRecentSearch: SaveRecentSearchUseCase,
    private val args: TeamsSearchNavigationArgs
) : BaseViewModel<TeamsUIState, SearchEvents>(TeamsUIState(), Event()) {


    init {
        initTeamList()
    }

    private fun initTeamList() {
        tryToExecute(
            { getSearchResult() },(::onSearchSuccess),(::onSearchError)
        )
    }

    private suspend fun getSearchResult(): List<TeamSearchUIState> {
        _state.update { it.copy(isResultEmpty = false, isLoading = true) }
        return getTeamsList(args.searchQuery).toSearchUIState(::onTeamClicked)
    }

    private fun onSearchSuccess(items: List<TeamSearchUIState>) {
        _state.update { it.copy(items = items, isLoading = false, isResultEmpty = items.isEmpty()) }
    }

    private fun onSearchError(throwable: Throwable) {
        _state.update { it.copy(error = throwable.message.toString()) }
    }

    private fun onTeamClicked(team: Team) {
        viewModelScope.launch {
            saveRecentSearch(team.toRecentSearch())
            _event.update { Event(SearchEvents.TeamClickEvent(team.id)) }
        }
    }

}