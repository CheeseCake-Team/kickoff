package com.cheesecake.presentation.screens.country.countryLeagues

import android.util.Log
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.ManageCompetitionsUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CountryLeaguesViewModel @Inject constructor(
    countryLeaguesArgs: CountryLeaguesArgs,
    private val manageCompetitionsUseCase: ManageCompetitionsUseCase
) : BaseViewModel<CountryLeaguesUIState, CountryLeaguesNavigationEvent>(
    CountryLeaguesUIState(),
    Event()
) {
    init {
        tryToExecute(
            { manageCompetitionsUseCase.getCompetitionsByCountryName(countryLeaguesArgs.countryName) },
            ::onSuccess,
            ::onError
        )
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

    private fun onError(t: Throwable) {
        Log.e("onError: ", t.localizedMessage.toString())
    }
}