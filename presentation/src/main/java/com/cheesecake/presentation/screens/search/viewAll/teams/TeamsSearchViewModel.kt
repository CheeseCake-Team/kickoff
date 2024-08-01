package com.cheesecake.presentation.screens.search.viewAll.teams

import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.usecases.ManageRecentSearchUseCase
import com.cheesecake.domain.usecases.ManageTeamsUseCase
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
    private val manageTeamsUseCase: ManageTeamsUseCase,
    private val manageRecentSearchUseCase: ManageRecentSearchUseCase,
    private val args: TeamsSearchNavigationArgs
) : BaseViewModel<TeamsUIState, SearchEvents>(TeamsUIState(), Event()) {
    init {
        getData()
    }

    private suspend fun getSearchResult(): List<TeamSearchUIState> {
        _state.update { it.copy(isResultEmpty = false, isLoading = true) }
        return manageTeamsUseCase.searchForTeams(args.searchQuery).toSearchUIState(::onTeamClicked)
    }

    private fun onSearchSuccess(items: List<TeamSearchUIState>) {
        _state.update { it.copy(items = items, isLoading = false, isResultEmpty = items.isEmpty()) }
    }

    private fun onTeamClicked(team: Team) {
        viewModelScope.launch {
            manageRecentSearchUseCase.addOrUpdateRecentSearch(team.toRecentSearch())
            _event.update { Event(SearchEvents.TeamClickEvent(team.id)) }
        }
    }

    override fun getData() {
        tryToExecute({ getSearchResult() }, ::onSearchSuccess)
    }
}