package com.cheesecake.presentation.screens.country.countryLeagues

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.ManageCompetitionsUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CountryLeaguesViewModel @Inject constructor(
    private val countryLeaguesArgs: CountryLeaguesArgs,
    private val manageCompetitionsUseCase: ManageCompetitionsUseCase
) : BaseViewModel<CountryLeaguesUiState, CountryLeaguesNavigationEvent>(
    CountryLeaguesUiState(),
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
        _event.update { Event(CountryLeaguesNavigationEvent.NavigateToLeague(leagueId)) }
    }

    override fun getData() {
        tryToExecute(
            { manageCompetitionsUseCase.getCompetitionsByCountryName(countryLeaguesArgs.countryName) },
            ::onSuccess,
        )
    }
}