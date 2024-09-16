package com.cheesecake.presentation.screens.competition

import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.Competition
import com.cheesecake.domain.usecases.ManageCompetitionsUseCase
import com.cheesecake.domain.usecases.ManageSeasonUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompetitionViewModel @Inject constructor(
    private val manageCompetitionsUseCase: ManageCompetitionsUseCase,
    private val competitionNavigationArgs: CompetitionNavigationArgs,
    private val manageSeasonUseCase: ManageSeasonUseCase,
) : BaseViewModel<CompetitionUiState, CompetitionNavigationEvent>(CompetitionUiState(), Event()) {
    val competitionId = competitionNavigationArgs.competitionId

    init {
        getData()
    }

    private fun onSuccess(competition: Competition) {
        _state.update { competitionUiState ->
            competitionUiState.copy(
                competitionName = competition.name,
                seasonStartEndYear = "${competition.seasonStartYear}/${competition.seasonEndYear}",
                imageUrl = competition.imageUrl,
            )
        }
    }

    override fun getData() {
        collectFlow(manageSeasonUseCase.getSeason()) { season ->
            copy(competitionSeason = season.toInt())
        }
        tryToExecute(
            {
                manageCompetitionsUseCase.getCompetitionByIdAndSeason(
                    competitionNavigationArgs.competitionId,
                    state.value.competitionSeason.toString()
                )
            },
            ::onSuccess,
        )
        viewModelScope.launch {
            collectFlow(manageCompetitionsUseCase.isCompetitionFavorite(competitionNavigationArgs.competitionId)) { isFavorite ->
                copy(isFavourite = isFavorite)
            }
        }
    }

    fun onFavoriteClick() {
        if (state.value.isFavourite) {
            viewModelScope.launch { manageCompetitionsUseCase.removeFavoriteCompetition(competitionId) }
        } else {
            tryToExecute({
                manageCompetitionsUseCase.favoriteCompetition(
                    competitionId,
                    state.value.competitionSeason.toString()
                )
            }, ::onFavoriteSuccess)
        }
    }

    private fun onFavoriteSuccess(unit: Unit) {
        _state.update { uiState -> uiState.copy(isFavourite = !state.value.isFavourite) }
    }

    fun onBackClick() {
        _event.update { Event(CompetitionNavigationEvent.NavigateBack) }
    }
}