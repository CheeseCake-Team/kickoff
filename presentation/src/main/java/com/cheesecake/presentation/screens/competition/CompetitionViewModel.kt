package com.cheesecake.presentation.screens.competition

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.ManageCompetitionsUseCase
import com.cheesecake.domain.usecases.ManageSeasonUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
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

    private fun onSuccess(competition: League) {
        _state.update { competitionUiState ->
            competitionUiState.copy(
                competitionName = competition.name,
                seasonStartEndYear = "${competition.seasonStartYear}/${competition.seasonEndYear}",
                imageUrl = competition.imageUrl,
                isFavourite = competition.isFavourite,
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
    }

    fun onFavoriteClick() {
        tryToExecute({manageCompetitionsUseCase.favoriteCompetition(
            competitionId,
            state.value.competitionSeason.toString()
        )
        }, ::onFavoriteSuccess)
    }

    private fun onFavoriteSuccess(competition: League) {
        _state.update { uiState -> uiState.copy(isFavourite = competition.isFavourite) }
    }

    fun onBackClick() {
        _event.update { Event(CompetitionNavigationEvent.NavigateBack) }
    }
}