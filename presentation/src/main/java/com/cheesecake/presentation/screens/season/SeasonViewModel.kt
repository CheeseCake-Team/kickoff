package com.cheesecake.presentation.screens.season

import com.cheesecake.domain.usecases.ManageSeasonUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SeasonViewModel @Inject constructor(
    private val manageSeasonUseCase: ManageSeasonUseCase
) : BaseViewModel<SeasonUiState, SeasonEvent>(SeasonUiState(), Event()) {
    init {
        getData()
    }

    override fun getData() {
        _isLoading.update { true }
        _errorUiState.update { null }
        collectFlow(manageSeasonUseCase.getSeason()) { season ->
            copy(selectedSeason = season)
        }
        tryToExecute({ manageSeasonUseCase.getAllSeasons() }, ::onGettingAllSeasonsSuccess)
    }

    private fun onGettingAllSeasonsSuccess(seasons: List<String>) {
        _state.update {
            it.copy(seasonItemsUiState = seasons.toUiState(it.selectedSeason, ::onSeasonClicked))
        }
        _isLoading.update { false }
        _errorUiState.update { null }
    }

    private fun onSeasonClicked(season: String) {
        tryToExecute({manageSeasonUseCase.setSeason(season)}, ::onUpdatingSeasonSuccess)

    }

    private fun onUpdatingSeasonSuccess(selectedSeason: String) {
        _state.update {
            it.copy(
                selectedSeason = selectedSeason,
                seasonItemsUiState = it.seasonItemsUiState.map { item ->
                    item.copy(isSelected = item.season == selectedSeason)
                }
            )
        }
    }

    fun onBackClicked() {
        _event.update { Event(SeasonEvent.OnBackClicked) }
    }
}