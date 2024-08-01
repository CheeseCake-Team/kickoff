package com.cheesecake.presentation.screens.country.countryTeams

import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.usecases.ManageTeamsUseCase
import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.mapper.toTeamUIState
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CountryTeamsViewModel @Inject constructor(
    private val countryTeamsArgs: CountryTeamsArgs,
    private val manageTeamsUseCase: ManageTeamsUseCase
) : BaseViewModel<CountyTeamsUiState, CountryTeamsNavigationEvent>(
    CountyTeamsUiState(), Event()
) {
    init {
        getData()
    }

    private fun onSuccess(teams: List<Team>) {
        _state.update { countryTeamsUIState ->
            countryTeamsUIState.copy(
                teams = teams.map { it.toTeamUIState { onTeamClick(it.id) } },
                isLoading = false
            )
        }
    }

    private fun onTeamClick(teamId: Int) {
        _event.update { Event(CountryTeamsNavigationEvent.NavigateToTeam(teamId)) }
    }

    override fun getData() {
        tryToExecute(
            { manageTeamsUseCase.getTeamsByCountryName(countryTeamsArgs.countryName) }, ::onSuccess
        )
    }
}