package com.cheesecake.presentation.screens.search.viewAll.competitions

import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.Competition
import com.cheesecake.domain.usecases.ManageCompetitionsUseCase
import com.cheesecake.domain.usecases.ManageRecentSearchUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import com.cheesecake.presentation.screens.search.SearchEvents
import com.cheesecake.presentation.screens.search.models.CompetitionSearchUiState
import com.cheesecake.presentation.screens.search.models.toRecentSearch
import com.cheesecake.presentation.screens.search.models.toSearchUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompetitionsSearchViewModel @Inject constructor(
    private val manageCompetitionsUseCase: ManageCompetitionsUseCase,
    private val manageRecentSearchUseCase: ManageRecentSearchUseCase,
    private val args: CompetitionsSearchNavigationArgs
) : BaseViewModel<CompetitionsSearchUiState, SearchEvents>(CompetitionsSearchUiState(), Event()) {
    init {
        getData()
    }

    private fun onSearchSuccess(items: List<CompetitionSearchUiState>) {
        _isLoading.update { false }
        _errorUiState.update { null }
        _state.update { it.copy(items = items, isResultEmpty = items.isEmpty()) }
    }

    private fun onCompetitionClicked(competition: Competition) {
        viewModelScope.launch {
            manageRecentSearchUseCase.addOrUpdateRecentSearch(competition.toRecentSearch())
            _event.update {
                Event(
                    SearchEvents.CompetitionClickEvent(
                        competition.competitionId,
                        competition.season.last().toString()
                    )
                )
            }
        }
    }

    override fun getData() {
        _isLoading.update { true }
        _errorUiState.update { null }
        tryToExecute({
            manageCompetitionsUseCase.searchForCompetitions(args.searchQuery)
                .toSearchUIState(::onCompetitionClicked)
        }, ::onSearchSuccess)
    }
}