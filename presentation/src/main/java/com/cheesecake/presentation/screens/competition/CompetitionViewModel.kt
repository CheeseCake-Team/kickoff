package com.cheesecake.presentation.screens.competition

import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.ManageCompetitionsUseCase
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
) : BaseViewModel<CompetitionUiState, CompetitionNavigationEvent>(CompetitionUiState(), Event()) {
    val competitionId = competitionNavigationArgs.competitionId

    init {
        getData()
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

    override fun getData() {
        tryToExecute(
            { manageCompetitionsUseCase.getCompetitionById(competitionNavigationArgs.competitionId) },
            ::onSuccess,
        )
    }

    fun onFavoriteClick() {
        viewModelScope.launch {
            manageCompetitionsUseCase.favoriteCompetition(competitionId).let {
                _state.update { uiState -> uiState.copy(isFavourite = it.isFavourite) }
            }
        }
    }

    fun onBackClick() {
        _event.update { Event(CompetitionNavigationEvent.NavigateBack) }
    }
}