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

    private fun onSuccess(leagues: List<League>) {
        _state.update { countryLeaguesUIState ->
            countryLeaguesUIState.copy(
                leagues = leagues.map { it.toLeagueUIState { onLeagueClick(it.leagueId) } },
                isLoading = false
            )
        }
    }

    private fun onLeagueClick(leagueId: Int) {
        _event.update { Event(CountryCompetitionsNavigationEvent.NavigateToCompetition(leagueId)) }
    }

    override fun getData() {
        tryToExecute(
            { manageCompetitionsUseCase.getCompetitionsByCountryName(countryCompetitionsArgs.countryName) },
            ::onSuccess,
        )
    }
}