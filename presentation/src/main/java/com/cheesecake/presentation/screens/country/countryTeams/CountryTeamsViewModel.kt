package com.cheesecake.presentation.screens.country.countryTeams

import android.util.Log
import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.usecases.GetCountryTeamsUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toTeamUIState
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CountryTeamsViewModel @Inject constructor(
    countryTeamsArgs: CountryTeamsArgs,
    private val getCountryTeamsUseCase: GetCountryTeamsUseCase
) : BaseViewModel<CountyTeamsUIState, CountryTeamsNavigationEvent>(
    CountyTeamsUIState(), Event()
) {
    init {
        tryToExecute({ getCountryTeamsUseCase(countryTeamsArgs.countryName) }, ::onSuccess, ::onError)

    }
    private fun onSuccess(teams: List<Team>) {
        _state.update {countryTeamsUIState ->
            countryTeamsUIState.copy(
                teams = teams.map { it.toTeamUIState { onTeamClick(it.id) } },
                isLoading = false
            )
        }
    }

    private fun onTeamClick(teamId: Int) {
        _event.update { Event(CountryTeamsNavigationEvent.NavigateToTeam(teamId)) }
    }

    private fun onError(t: Throwable) {
        Log.e("onError: ", t.localizedMessage.toString())
    }

}