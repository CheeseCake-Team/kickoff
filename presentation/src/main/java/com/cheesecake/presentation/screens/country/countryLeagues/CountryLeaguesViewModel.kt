package com.cheesecake.presentation.screens.country.countryLeagues

import android.util.Log
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.usecases.GetLeaguesByCountryName
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.*
import com.cheesecake.presentation.screens.league.toLeagueUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CountryLeaguesViewModel @Inject constructor(
    countryLeaguesArgs: CountryLeaguesArgs,
    private val getLeaguesByCountryName: GetLeaguesByCountryName
) : BaseViewModel<CountryLeaguesUIState, CountryLeaguesNavigationEvent>(
        CountryLeaguesUIState(),
        Event()
    ) {

    init {
        tryToExecute({ getLeaguesByCountryName(countryLeaguesArgs.countryName) }, ::onSuccess, ::onError)
    }

    private fun onSuccess(leagues: List<League>) {
        _state.update { countryLeaguesUIState ->
            countryLeaguesUIState.copy(
                leagues = leagues.map { it.toLeagueUIState { onLeagueClick(it.leagueId, it.season.toInt()) } },
                isLoading = false
            )
        }
    }

    private fun onLeagueClick(leagueId: Int, leagueSeason: Int) {
        _event.update { Event(CountryLeaguesNavigationEvent.NavigateToLeague(leagueId, leagueSeason)) }
    }

    private fun onError(t: Throwable) {
        Log.e("onError: ", t.localizedMessage.toString())
    }

}