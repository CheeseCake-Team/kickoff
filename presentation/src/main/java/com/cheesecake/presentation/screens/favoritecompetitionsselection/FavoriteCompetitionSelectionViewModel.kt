package com.cheesecake.presentation.screens.favoritecompetitionsselection

import com.cheesecake.domain.entity.Competition
import com.cheesecake.domain.usecases.ManageCompetitionsUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toUiState
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class FavoriteCompetitionSelectionViewModel @Inject constructor(
    private val manageCompetitionsUseCase: ManageCompetitionsUseCase,
) : BaseViewModel<FavoriteCompetitionSelectionUiState, FavoriteCompetitionSelectionNavigationEvent>(
    FavoriteCompetitionSelectionUiState(),
    Event()
) {
    init {
        getData()
    }

    private fun onGettingCompetitionsSuccess(competitions: List<Competition>) {
        _isLoading.update { false }
        _errorUiState.update { null }
        val competitionsUiState = competitions.toUiState { onCompetitionClick(it) }
        _state.update {
            it.copy(
                displayedCompetitions = competitionsUiState,
                competitionsItemUiState = competitionsUiState,
                isNoResult = competitions.isEmpty(),
                onNextClick = { addCompetitionsToFavourite() },
            )
        }
    }

    private fun onCompetitionClick(competition: Competition) {
        manageCompetitionsUseCase.addCompetition(competition)
        _state.update { favLeagueSelectionUIState ->
            favLeagueSelectionUIState.copy(
                displayedCompetitions = state.value.displayedCompetitions.map {
                    if (it.competitionId == competition.competitionId) it.copy(isSelected = !it.isSelected) else it
                },
                competitionsItemUiState = state.value.competitionsItemUiState.map {
                    if (it.competitionId == competition.competitionId) it.copy(isSelected = !it.isSelected) else it
                },
            )
        }
    }

    fun onSearchQueryChanged(searchQuery: CharSequence) {
        val displayedCompetitions = if (searchQuery.isNotBlank()) {
            state.value.competitionsItemUiState.filter {
                it.competitionName.contains(searchQuery, true)
            }
        } else {
            state.value.competitionsItemUiState
        }
        _isLoading.update { false }
        _state.update {
            it.copy(
                isNoResult = displayedCompetitions.isEmpty(),
                displayedCompetitions = displayedCompetitions,
            )
        }
    }

    private fun addCompetitionsToFavourite() {
        tryToExecute({ manageCompetitionsUseCase.saveCompetitions() }, ::onAddingSuccess)
    }

    private fun onAddingSuccess(boolean: Boolean) {
        _event.update { Event(FavoriteCompetitionSelectionNavigationEvent.NavigateToFavoriteTeamsSelection) }
    }

    override fun getData() {
        _isLoading.update { true }
        _errorUiState.update { null }
        _state.update { it.copy(isNoResult = false) }
        tryToExecute(
            { manageCompetitionsUseCase.getCompetitions() },
            ::onGettingCompetitionsSuccess
        )
    }
}