package com.cheesecake.presentation.screens.favoritecompetitionsselection

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.ManageCompetitionUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toUiState
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class FavoriteCompetitionSelectionViewModel @Inject constructor(
    private val manageCompetitionUseCase: ManageCompetitionUseCase,
) : BaseViewModel<FavoriteCompetitionSelectionUiState, FavoriteCompetitionSelectionNavigationEvent>(
    FavoriteCompetitionSelectionUiState(),
    Event()
) {
    init {
        tryToExecute({ manageCompetitionUseCase.getCompetitions() }, ::onGettingCompetitionsSuccess, ::onError)
    }

    private fun onGettingCompetitionsSuccess(competitions: List<League>) {
        val competitionsUiState = competitions.toUiState { onCompetitionClick(it) }
        _state.update {
            it.copy(
                displayedCompetitions = competitionsUiState,
                competitionsItemUiState = competitionsUiState,
                isLoading = false,
                isNoResult = competitions.isEmpty(),
                onNextClick = { addCompetitionsToFavourite() },
            )
        }
    }

    private fun onCompetitionClick(competition: League) {
        manageCompetitionUseCase.addCompetition(competition)
        _state.update { favLeagueSelectionUIState ->
            favLeagueSelectionUIState.copy(
                displayedCompetitions = state.value.displayedCompetitions.map {
                    if (it.competitionId == competition.leagueId) it.copy(isSelected = !it.isSelected) else it
                },
                competitionsItemUiState = state.value.competitionsItemUiState.map {
                    if (it.competitionId == competition.leagueId) it.copy(isSelected = !it.isSelected) else it
                },
            )
        }
    }

    fun onSearchQueryChanged(searchQuery: CharSequence) {
        val displayedCompetitions = if (searchQuery.isNotBlank())
            state.value.competitionsItemUiState.filter {
                it.competitionName.contains(searchQuery, true)
            }
        else
            state.value.competitionsItemUiState
        _state.update {
            it.copy(
                isLoading = false,
                isNoResult = displayedCompetitions.isEmpty(),
                displayedCompetitions = displayedCompetitions,
            )
        }
    }

    private fun addCompetitionsToFavourite() {
        tryToExecute({ manageCompetitionUseCase.saveCompetitions() }, ::onAddingSuccess, ::onError)
    }

    private fun onAddingSuccess(boolean: Boolean) {
        _event.update { Event(FavoriteCompetitionSelectionNavigationEvent.NavigateToFavoriteTeamsSelection) }
    }

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(
                errorMessage = e.localizedMessage ?: "Unknown error.",
                isLoading = false
            )
        }
    }
}