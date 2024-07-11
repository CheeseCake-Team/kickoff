package com.cheesecake.presentation.screens.competition

import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.ManageCompetitionUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompetitionViewModel @Inject constructor(
    private val manageCompetitionUseCase: ManageCompetitionUseCase,
    private val competitionNavigationArgs: CompetitionNavigationArgs,
) : BaseViewModel<CompetitionUiState, CompetitionNavigationEvent>(CompetitionUiState(), Event()) {
    val competitionId = competitionNavigationArgs.competitionId

    init {
        tryToExecute(
            { manageCompetitionUseCase.getCompetitionById(competitionNavigationArgs.competitionId) },
            ::onSuccess,
            ::onError
        )
    }

    private fun onSuccess(competition: League) {
        _state.update { competitionUiState ->
            competitionUiState.copy(
                competitionSeason = competition.season.last(),
                competitionName = competition.name,
                seasonStartEndYear = "${competition.seasonStartYear}/${competition.seasonEndYear}",
                imageUrl = competition.imageUrl,
                isFavourite = competition.isFavourite,
            )
        }
    }

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(
                errorMessage = e.message ?: "Unknown error.",
                isLoading = false
            )
        }
    }

    fun onFavoriteClick() {
        viewModelScope.launch {
            manageCompetitionUseCase.favoriteCompetition(competitionId).let {
                _state.update { uiState -> uiState.copy(isFavourite = it.isFavourite) }
            }
        }
    }

    fun onBackClick() {
        _event.update { Event(CompetitionNavigationEvent.NavigateBack) }
    }
}