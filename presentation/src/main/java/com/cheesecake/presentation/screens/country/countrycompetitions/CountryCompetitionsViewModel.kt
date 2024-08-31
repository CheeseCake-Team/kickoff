package com.cheesecake.presentation.screens.country.countrycompetitions

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.ManageCompetitionsUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CountryCompetitionsViewModel @Inject constructor(
    private val countryCompetitionsArgs: CountryCompetitionsArgs,
    private val manageCompetitionsUseCase: ManageCompetitionsUseCase
) : BaseViewModel<CountryCompetitionsUiState, CountryCompetitionsNavigationEvent>(
    CountryCompetitionsUiState(),
    Event()
) {
    init {
        getData()
    }

    private fun onSuccess(competitions: List<League>) {
        _isLoading.update { false }
        _errorUiState.update { null }
        _state.update { countryLeaguesUIState ->
            countryLeaguesUIState.copy(
                competitions = competitions.map { it.toCompetitionUIState { onCompetitionClicked(it.competitionId) } },
            )
        }
    }

    private fun onCompetitionClicked(competitionId: Int) {
        _event.update { Event(CountryCompetitionsNavigationEvent.NavigateToCompetition(competitionId)) }
    }

    override fun getData() {
        _isLoading.update { true }
        _errorUiState.update { null }
        tryToExecute(
            { manageCompetitionsUseCase.getCompetitionsByCountryName(countryCompetitionsArgs.countryName) },
            ::onSuccess,
        )
    }
}